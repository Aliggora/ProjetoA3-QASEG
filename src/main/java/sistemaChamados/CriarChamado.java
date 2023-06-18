package sistemaChamados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CriarChamado {
    private JFrame frame;
    private JTextField assuntoTextField;
    private JTextArea descricaoTextArea;
    private JButton criarButton;

    public CriarChamado() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());

        JLabel lblNewLabel = new JLabel("Assunto:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        assuntoTextField = new JTextField();
        GridBagConstraints gbc_assuntoTextField = new GridBagConstraints();
        gbc_assuntoTextField.insets = new Insets(0, 0, 5, 0);
        gbc_assuntoTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_assuntoTextField.gridx = 1;
        gbc_assuntoTextField.gridy = 0;
        panel.add(assuntoTextField, gbc_assuntoTextField);
        assuntoTextField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Descrição:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        descricaoTextArea = new JTextArea();
        GridBagConstraints gbc_descricaoTextArea = new GridBagConstraints();
        gbc_descricaoTextArea.fill = GridBagConstraints.BOTH;
        gbc_descricaoTextArea.gridx = 1;
        gbc_descricaoTextArea.gridy = 1;
        panel.add(new JScrollPane(descricaoTextArea), gbc_descricaoTextArea);

        criarButton = new JButton("Criar");
        criarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String assunto = assuntoTextField.getText();
                String descricao = descricaoTextArea.getText();
                String dataHora = LocalDateTime.now().toString();

                // Salvar as informações em "chamados.csv"
                try (PrintWriter writer = new PrintWriter(new FileWriter("chamados.csv", true))) {
                    writer.println("Assunto: " + assunto);
                    writer.println("Descrição: " + descricao);
                    writer.println("Data/Hora: " + dataHora);
                    writer.println();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(frame, "Chamado criado com sucesso!");
                frame.dispose();
            }
        });
        frame.getContentPane().add(criarButton, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getCriarButton() {
        return criarButton;
    }

    public JTextField getAssuntoTextField() {
        return assuntoTextField;
    }

    public JTextArea getDescricaoTextArea() {
        return descricaoTextArea;
    }

    public JFrame getFrame() {
        return frame;
    }
}
