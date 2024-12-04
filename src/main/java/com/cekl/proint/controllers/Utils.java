package com.cekl.proint.controllers;

import com.cekl.proint.models.Selection;
import com.cekl.proint.models.Ticket;
import com.cekl.proint.models.User;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void adicionarTicketAoCSV(Selection selection) {
        // catalogo das areas
        String[] areas = {"Plateia A", "Plateia B", "Frisa1", "Frisa2", "Frisa3", "Frisa4", "Frisa5", "Frisa6",
            "Camarote1", "Camarote2", "Camarote3", "Camarote4", "Camarote5", "Balcão Nobre"};

        //csv path
        Path csvFile = Paths.get("data", "Tickets.csv");
        // 1. Criar um objeto Ticket a partir do Selection
        Ticket ticket = new Ticket(
                selection.getCpf(),
                selection.getPeca(),
                selection.getSessao(),
                areas[selection.getArea()],
                selection.getPoltrona(),
                selection.getAreaPreco()
        );

        // 2. Obter a data atual para adicionar ao arquivo CSV
        String dataCompra = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // 3. Formatar os dados do ticket para a linha do CSV
        String linhaCSV = ticket.getCpf() + ","
                + ticket.getPeca() + ","
                + ticket.getSessao() + ","
                + ticket.getArea() + ","
                + ticket.getPoltrona() + ","
                + ticket.getPreco() + ","
                + dataCompra;

        // 4. Adicionar a linha ao arquivo CSV
        try (FileWriter writer = new FileWriter(csvFile.toFile(), true)) {
            writer.append(linhaCSV);
            writer.append("\n");
            System.out.println("Ticket adicionado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar o ticket ao CSV: " + e.getMessage());
        }
    }

    public static void adicionarUsuarioAoCSV(User usuario) {
        //csv path
        Path csvFile = Paths.get("data", "User.csv");

        // 1. Obter a data atual para adicionar ao arquivo CSV
        String dataCadastro = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // 2. Formatar os dados do ticket para a linha do CSV
        String linhaCSV = usuario.getCpf() + ","
                + usuario.getNome() + ","
                + usuario.getTelefone() + ","
                + usuario.getDataNascimento() + ","
                + usuario.getEndereco() + ","
                + dataCadastro;

        // 3. Adicionar a linha ao arquivo CSV
        try (FileWriter writer = new FileWriter(csvFile.toFile(), true)) {
            writer.append(linhaCSV);
            writer.append("\n");
            System.out.println("Usuário adicionado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao adicionar o usuario ao CSV: " + e.getMessage());
        }
    }

    public static boolean isCPFValid(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        // Validações básicas
        if (cpf.length() != 11
                || cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222")
                || cpf.equals("33333333333")
                || cpf.equals("44444444444")
                || cpf.equals("55555555555")
                || cpf.equals("66666666666")
                || cpf.equals("77777777777")
                || cpf.equals("88888888888")
                || cpf.equals("99999999999")) {
            return false;
        }

        try {
            int d1 = 0, d2 = 0, digito1 = 0, digito2 = 0, resto = 0;

            // Calcula o primeiro dígito verificador
            for (int i = 1; i <= 9; i++) {
                d1 += Integer.parseInt(cpf.substring(i - 1, i)) * (11 - i);
            }
            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }

            // Calcula o segundo dígito verificador
            d2 = 0;
            for (int i = 1; i <= 10; i++) {
                d2 += Integer.parseInt(cpf.substring(i - 1, i)) * (12 - i);
            }
            resto = (d2 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados no CPF
            String digitos = cpf.substring(9, 11);
            return digitos.equals(Integer.toString(digito1) + Integer.toString(digito2));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
