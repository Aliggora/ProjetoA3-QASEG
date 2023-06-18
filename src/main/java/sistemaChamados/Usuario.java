package sistemaChamados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String registro;
    private String username;
    private String senha;

    public Usuario(String nome, String registro, String username, String senha) {
        this.nome = nome;
        this.registro = registro;
        this.username = username;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getRegistro() {
        return registro;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public static List<Usuario> lerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String nome = data[0];
                String re = data[1];
                String username = data[2];
                String senha = data[3];
                Usuario usuario = new Usuario(nome, re, username, senha);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static void gravarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.csv"))) {
            for (Usuario usuario : usuarios) {
                String line = usuario.getNome() + "," + usuario.getRegistro() + "," + usuario.getUsername() + "," + usuario.getSenha();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
