package com.cekl.proint.controllers;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

// Classe responsável por buscar tickets em um arquivo CSV baseado no CPF fornecido pelo usuário.
public class BuscarTicketsPorCPF {

    public static void main() {
        // Define o caminho do arquivo CSV contendo os tickets.
        Path csvPathTicket = Paths.get("data", "Tickets.csv");
        Path csvPathUser = Paths.get("data", "User.csv");

        // Solicita ao usuário que insira o CPF por meio de uma caixa de diálogo.
        String cpf = JOptionPane.showInputDialog(null, "Digite o CPF:", "Buscar Tickets", JOptionPane.QUESTION_MESSAGE);

        // Verifica se o CPF é nulo ou vazio e exibe uma mensagem de erro caso inválido.
        if (cpf == null || cpf.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Busca os tickets associados ao CPF fornecido.
            List<String> tickets = buscarTicketsPorCPF(csvPathTicket, cpf.trim());
            List<String> user = buscarUserPorCPF(csvPathUser, cpf.trim());

            // Verifica se foram encontrados tickets. Caso contrário, exibe uma mensagem informativa.
            if (tickets.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum ticket encontrado para o CPF: " + cpf, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Exibe os tickets encontrados em um JDialog.
                exibirTickets(cpf, tickets, user);
            }

        } catch (IOException e) {
            // Trata erros de leitura do arquivo e exibe uma mensagem de erro.
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo CSV: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método que busca tickets no arquivo CSV associados a um CPF específico.
    static List<String> buscarTicketsPorCPF(Path csvPath, String cpf) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            // Lê todas as linhas do arquivo CSV, ignora o cabeçalho e filtra as linhas que começam com o CPF.
            return reader.lines()
                    .skip(1) // Ignora a primeira linha (cabeçalho do arquivo).
                    .filter(line -> line.startsWith(cpf + ",")) // Filtra linhas cujo CPF coincide com o informado.
                    .collect(Collectors.toList()); // Coleta as linhas filtradas em uma lista.
        }
    }

    // Busca  o usuário no cadastro de fidelidade
    static List<String> buscarUserPorCPF(Path csvPath, String cpf) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(csvPath)) {
            // Lê todas as linhas do arquivo CSV, ignora o cabeçalho e filtra as linhas que começam com o CPF.
            return reader.lines()
                    .skip(1) // Ignora a primeira linha (cabeçalho do arquivo).
                    .filter(line -> line.startsWith(cpf + ",")) // Filtra linhas cujo CPF coincide com o informado.
                    .collect(Collectors.toList()); // Coleta as linhas filtradas em uma lista.
        }
    }

    // Método para formatar ao cadastro de um usuário, tornando a exibição mais legível.
    public static String descreverUser(String ticket) {
        // Divide a string do User em campos separados por vírgula.
        String[] campos = ticket.split(",");

        // Retorna uma descrição formatada do User usando os campos extraídos.
        return String.format("""
                Cliente: %s
                CPF: %s
                Telefone: %s
                Endereço: %s
                Data de Nascimento: %s
                """,
                campos[1], // Nome do cliente
                campos[0], // CPF do cliente.
                campos[2], // Telefone do cliente.
                campos[3], // Endereço informado pelo cliente.
                campos[4] // data te nascimento od cliente.
        );
    }

    // Método para formatar a descrição de um ticket, tornando a exibição mais legível.
    public static String descreverTicket(String ticket) {
        // Divide a string do ticket em campos separados por vírgula.
        String[] campos = ticket.split(",");

        // Retorna uma descrição formatada do ticket usando os campos extraídos.
        return String.format("""
                Peça: %s
                Sessão: %s
                Área: %s
                Poltrona: %s
                Preço: R$ %.2f
                Data da Compra: %s
                """,
                campos[1], // Nome da peça.
                campos[2], // Sessão do teatro.
                campos[3], // Área do teatro.
                campos[4], // Número da poltrona.
                Double.parseDouble(campos[5]), // Preço do ticket, convertido para Double.
                campos[6] // Data em que o ticket foi comprado.
        );
    }

    // Método para exibir os tickets encontrados em uma caixa de diálogo.
    static void exibirTickets(String cpf, List<String> tickets, List<String>  users) {
        String user = users.get(0);
        // Constrói uma string contendo a lista de tickets encontrados.
        StringBuilder builder = new StringBuilder();
        
        builder.append(descreverUser(user)).append("\n\n");
        
        for (String ticket : tickets) {
            builder.append(descreverTicket(ticket)).append("\n"); // Adiciona cada ticket formatado.
        }

        // Configura um JTextArea para exibir os tickets de forma legível.
        JTextArea textArea = new JTextArea(builder.toString());
        
        textArea.setEditable(false); // Impede edição do texto.
        
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Define uma fonte monoespaçada.

        // Envolve o JTextArea em um JScrollPane para permitir rolagem, caso necessário.
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Define o tamanho da janela de exibição.

        // Exibe os tickets encontrados em uma mensagem informativa.
        JOptionPane.showMessageDialog(null, scrollPane, "Tickets Encontrados", JOptionPane.INFORMATION_MESSAGE);
    }
}
