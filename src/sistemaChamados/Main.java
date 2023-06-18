package sistemaChamados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private JFrame frame;
    private JTextField usernameTextField;
    private JPasswordField passwordField;

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());

        JLabel lblNewLabel = new JLabel("Usuário:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        usernameTextField = new JTextField();
        GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
        gbc_usernameTextField.insets = new Insets(0, 0, 5, 0);
        gbc_usernameTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_usernameTextField.gridx = 1;
        gbc_usernameTextField.gridy = 0;
        panel.add(usernameTextField, gbc_usernameTextField);
        usernameTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Senha:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 1;
        gbc_passwordField.gridy = 1;
        panel.add(passwordField, gbc_passwordField);

        JButton loginButton = new JButton("Enviar");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("admin") && new String(password).equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Admin logado com sucesso!");
                    frame.dispose();
                    openAdminOptions();
                } else if (username.equals("user") && new String(password).equals("user")) {
                    JOptionPane.showMessageDialog(frame, "User logado com sucesso!");
                    frame.dispose();
                    openUserOptions();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos");
                }

                // Limpa o textbox de senha.
                passwordField.setText("");
            }
        });
        frame.getContentPane().add(loginButton, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void openAdminOptions() {
        JFrame adminFrame = new JFrame();
        adminFrame.setBounds(100, 100, 400, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        adminFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());

        JButton verificarChamadosButton = new JButton("Verificar chamados abertos");
        verificarChamadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> chamadosAbertos = readChamadosCSV();
                String chamadosString = String.join("\n", chamadosAbertos);
                JOptionPane.showMessageDialog(adminFrame, "Chamados abertos:\n" + chamadosString);
            }
        });
        GridBagConstraints gbc_verificarChamadosButton = new GridBagConstraints();
        gbc_verificarChamadosButton.insets = new Insets(0, 0, 5, 0);
        gbc_verificarChamadosButton.gridx = 0;
        gbc_verificarChamadosButton.gridy = 0;
        panel.add(verificarChamadosButton, gbc_verificarChamadosButton);

        JButton cadastrarMembrosButton = new JButton("Cadastrar membros de equipe");
        cadastrarMembrosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCompleto = JOptionPane.showInputDialog(adminFrame, "Digite o nome completo:");
                String re = JOptionPane.showInputDialog(adminFrame, "Digite o RE do funcionário:");
                String nomeUsuario = JOptionPane.showInputDialog(adminFrame, "Digite o nome de usuário:");
                String senhaAcesso = JOptionPane.showInputDialog(adminFrame, "Digite a senha de acesso:");

                // Salvar as informações em "usuarios.csv"

                JOptionPane.showMessageDialog(adminFrame, "Membro de equipe cadastrado com sucesso!");
            }
        });
        GridBagConstraints gbc_cadastrarMembrosButton = new GridBagConstraints();
        gbc_cadastrarMembrosButton.insets = new Insets(0, 0, 5, 0);
        gbc_cadastrarMembrosButton.gridx = 0;
        gbc_cadastrarMembrosButton.gridy = 1;
        panel.add(cadastrarMembrosButton, gbc_cadastrarMembrosButton);

        JButton cadastrarClientesButton = new JButton("Cadastrar clientes");
        cadastrarClientesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = JOptionPane.showInputDialog(adminFrame, "Digite o nome do cliente:");
                String cnpj = JOptionPane.showInputDialog(adminFrame, "Digite o CNPJ do cliente:");
                String nomeUsuario = JOptionPane.showInputDialog(adminFrame, "Digite o nome de usuário:");
                String senhaAcesso = JOptionPane.showInputDialog(adminFrame, "Digite a senha de acesso:");

                // Salvar as informações em "clientes.csv"

                JOptionPane.showMessageDialog(adminFrame, "Cliente cadastrado com sucesso!");
            }
        });
        GridBagConstraints gbc_cadastrarClientesButton = new GridBagConstraints();
        gbc_cadastrarClientesButton.insets = new Insets(0, 0, 5, 0);
        gbc_cadastrarClientesButton.gridx = 0;
        gbc_cadastrarClientesButton.gridy = 2;
        panel.add(cadastrarClientesButton, gbc_cadastrarClientesButton);

        JButton abrirChamadoButton = new JButton("Abrir chamado");
        abrirChamadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTicketCreation();
            }
        });
        GridBagConstraints gbc_abrirChamadoButton = new GridBagConstraints();
        gbc_abrirChamadoButton.insets = new Insets(0, 0, 5, 0);
        gbc_abrirChamadoButton.gridx = 0;
        gbc_abrirChamadoButton.gridy = 3;
        panel.add(abrirChamadoButton, gbc_abrirChamadoButton);

        JButton desconectarButton = new JButton("Desconectar");
        desconectarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                Main login = new Main();
                login.show();
            }
        });
        GridBagConstraints gbc_desconectarButton = new GridBagConstraints();
        gbc_desconectarButton.gridx = 0;
        gbc_desconectarButton.gridy = 4;
        panel.add(desconectarButton, gbc_desconectarButton);

        adminFrame.setVisible(true);
    }

    private void openUserOptions() {
        JFrame userFrame = new JFrame();
        userFrame.setBounds(100, 100, 400, 200);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        userFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());

        JButton abrirChamadoButton = new JButton("Abrir novo chamado");
        abrirChamadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTicketCreation();
            }
        });
        GridBagConstraints gbc_abrirChamadoButton = new GridBagConstraints();
        gbc_abrirChamadoButton.insets = new Insets(0, 0, 5, 0);
        gbc_abrirChamadoButton.gridx = 0;
        gbc_abrirChamadoButton.gridy = 0;
        panel.add(abrirChamadoButton, gbc_abrirChamadoButton);

        JButton verificarStatusButton = new JButton("Verificar status de chamado");
        verificarStatusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> chamadosUsuario = readChamadosCSV();
                String ultimoChamado = chamadosUsuario.get(chamadosUsuario.size() - 1);
                JOptionPane.showMessageDialog(userFrame, "Último chamado aberto:\n" + ultimoChamado);
            }
        });
        GridBagConstraints gbc_verificarStatusButton = new GridBagConstraints();
        gbc_verificarStatusButton.insets = new Insets(0, 0, 5, 0);
        gbc_verificarStatusButton.gridx = 0;
        gbc_verificarStatusButton.gridy = 1;
        panel.add(verificarStatusButton, gbc_verificarStatusButton);

        JButton desconectarButton = new JButton("Desconectar");
        desconectarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
                Main login = new Main();
                login.show();
            }
        });
        GridBagConstraints gbc_desconectarButton = new GridBagConstraints();
        gbc_desconectarButton.gridx = 0;
        gbc_desconectarButton.gridy = 2;
        panel.add(desconectarButton, gbc_desconectarButton);

        userFrame.setVisible(true);
    }

    private void openTicketCreation() {
        CriarChamado criarChamado = new CriarChamado();
        criarChamado.show();
    }

    private List<String> readChamadosCSV() {
        List<String> chamados = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("chamados.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chamados.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chamados;
    }

    public static void main(String[] args) {
        Main login = new Main();
        login.show();
    }
}
