package com.cekl.proint.controllers;

import com.cekl.proint.models.Area;
import com.cekl.proint.models.Client;
import com.cekl.proint.models.Piece;
import com.cekl.proint.models.Seats;
import com.cekl.proint.models.Selection;
import com.cekl.proint.models.Ticket;
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
                selection.getAreaPreco() // Aqui, assumimos que a área tem o método getPreco()
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
}
