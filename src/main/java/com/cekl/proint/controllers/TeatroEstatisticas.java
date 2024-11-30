package com.cekl.proint.controllers;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
//classe que gera as estatísticas
public class TeatroEstatisticas {

    public static void main() {
        Path csvPath = Paths.get("data","Tickets.csv");

        try {
            // Lê os dados do arquivo CSV
            List<Venda> vendas = lerDados(csvPath);

            // Calcula as estatísticas
            String estatisticas = gerarEstatisticas(vendas);

            // Mostra as estatísticas em um JDialog
            mostrarEstatisticas(estatisticas);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo CSV: " + e.getMessage() + csvPath.toAbsolutePath(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Classe auxiliar para armazenar os dados de uma venda
    static class Venda {
        String cpf, peca, sessao, area, poltrona;
        double preco;
        String dataCompra;

        public Venda(String cpf, String peca, String sessao, String area, String poltrona, double preco, String dataCompra) {
            this.cpf = cpf;
            this.peca = peca;
            this.sessao = sessao;
            this.area = area;
            this.poltrona = poltrona;
            this.preco = preco;
            this.dataCompra = dataCompra;
        }
    }

    // Método para ler os dados do CSV
    static List<Venda> lerDados(Path csvPath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            // Ignora o cabeçalho e processa as linhas
            return reader.lines()
                    .skip(1)
                    .map(line -> {
                        String[] campos = line.split(",");
                        return new Venda(campos[0], campos[1], campos[2], campos[3], campos[4],
                                Double.parseDouble(campos[5]), campos[6]);
                    })
                    .collect(Collectors.toList());
        }
    }

    // Método para gerar as estatísticas
    static String gerarEstatisticas(List<Venda> vendas) {
        Map<String, Long> ingressosPorPeca = vendas.stream()
                .collect(Collectors.groupingBy(venda -> venda.peca, Collectors.counting()));

        Map<String, Long> ocupacaoPorSessao = vendas.stream()
                .collect(Collectors.groupingBy(venda -> venda.sessao, Collectors.counting()));

        Map<String, Double> lucroPorPecaSessao = vendas.stream()
                .collect(Collectors.groupingBy(
                        venda -> venda.peca + " - " + venda.sessao,
                        Collectors.summingDouble(venda -> venda.preco)
                ));

        Map<String, Double> lucroPorPeca = vendas.stream()
                .collect(Collectors.groupingBy(venda -> venda.peca, Collectors.summingDouble(venda -> venda.preco)));

        String pecaMaisIngressos = Collections.max(ingressosPorPeca.entrySet(), Map.Entry.comparingByValue()).getKey();
        String pecaMenosIngressos = Collections.min(ingressosPorPeca.entrySet(), Map.Entry.comparingByValue()).getKey();

        String sessaoMaiorOcupacao = Collections.max(ocupacaoPorSessao.entrySet(), Map.Entry.comparingByValue()).getKey();
        String sessaoMenorOcupacao = Collections.min(ocupacaoPorSessao.entrySet(), Map.Entry.comparingByValue()).getKey();

        String pecaSessaoMaisLucrativa = Collections.max(lucroPorPecaSessao.entrySet(), Map.Entry.comparingByValue()).getKey();
        String pecaSessaoMenosLucrativa = Collections.min(lucroPorPecaSessao.entrySet(), Map.Entry.comparingByValue()).getKey();

        double lucroMedioPorPeca = lucroPorPeca.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);

        return String.format("""
                Estatísticas de Vendas:
                
                - Peça com mais ingressos vendidos: %s
                - Peça com menos ingressos vendidos: %s
                
                - Sessão com maior ocupação de poltronas: %s
                - Sessão com menor ocupação de poltronas: %s
                
                - Peça/Sessão mais lucrativa: %s
                - Peça/Sessão menos lucrativa: %s
                
                - Lucro médio por peça: R$ %.2f
                """,
                pecaMaisIngressos, pecaMenosIngressos,
                sessaoMaiorOcupacao, sessaoMenorOcupacao,
                pecaSessaoMaisLucrativa, pecaSessaoMenosLucrativa,
                lucroMedioPorPeca);
    }

    // Método para exibir as estatísticas em um JDialog
    static void mostrarEstatisticas(String estatisticas) {
        JTextArea textArea = new JTextArea(estatisticas);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Estatísticas",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
