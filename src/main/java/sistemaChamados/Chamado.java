package sistemaChamados;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chamado {
    private int id;
    private String assunto;
    private String descricao;
    private String status;
    private String responsavel;

    public Chamado(int id, String assunto, String descricao, String status, String responsavel) {
        this.id = id;
        this.assunto = assunto;
        this.descricao = descricao;
        this.status = status;
        this.responsavel = responsavel;
    }
    
    public int getId() {
        return id;
    }

    public String getAssunto() {
        return assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public static List<Chamado> lerChamados() throws CsvValidationException {
        List<Chamado> chamados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("chamados.csv"))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String assunto = line[1];
                String descricao = line[2];
                String status = line[3];
                String responsavel = line[4];
                Chamado chamado = new Chamado(id, assunto, descricao, status, responsavel);
                chamados.add(chamado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chamados;
    }

    public static void gravarChamados(List<Chamado> chamados) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("chamados.csv"))) {
            for (Chamado chamado : chamados) {
                String[] line = {String.valueOf(chamado.getId()), chamado.getAssunto(), chamado.getDescricao(),
                        chamado.getStatus(), chamado.getResponsavel()};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

