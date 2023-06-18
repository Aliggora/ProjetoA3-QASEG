package sistemaChamados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton loginButton = new JButton("Entrar");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("admin") && new String(password).equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Admin logado com sucesso!");
                    frame.dispose();
                    openTicketCreation();
                } else if (username.equals("user") && new String(password).equals("user")) {
                    JOptionPane.showMessageDialog(frame, "User logado com sucesso!");
                    frame.dispose();
                    openTicketCreation();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos");
                }

                // Clear the password field
                passwordField.setText("");
            }
        });
        frame.getContentPane().add(loginButton, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void openTicketCreation() {
        CriarChamado criarChamado = new CriarChamado();
        criarChamado.show();
    }

    public static void main(String[] args) {
        Main login = new Main();
        login.show();
    }
}