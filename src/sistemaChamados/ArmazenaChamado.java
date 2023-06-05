package sistemaChamados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ArmazenaChamado {
    private static final String FILENAME = "chamados.csv";

    public static void salvarChamado(Chamado chamado) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME, true))) {
            String linha = chamado.getTipo() + "," + chamado.getDescricao();
            writer.println(linha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Chamado> carregarChamados() {
        List<Chamado> chamados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length == 2) {
                    String tipo = campos[0];
                    String descricao = campos[1];
                    Chamado chamado = new Chamado(tipo, descricao);
                    chamados.add(chamado);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chamados;
    }

    public static void salvarChamados(List<Chamado> chamados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Chamado chamado : chamados) {
                String linha = chamado.getTipo() + "," + chamado.getDescricao();
                writer.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
