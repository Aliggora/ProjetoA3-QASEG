package sistemaChamados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class CriarChamado {
    private JFrame frame;
    private JComboBox<String> tipoComboBox;
    private JTextArea descricaoTextArea;

    public CriarChamado() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridBagLayout());

        JLabel lblNewLabel = new JLabel("Tipo de Chamado:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        panel.add(lblNewLabel, gbc_lblNewLabel);

        tipoComboBox = new JComboBox<>();
        GridBagConstraints gbc_tipoComboBox = new GridBagConstraints();
        gbc_tipoComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_tipoComboBox.insets = new Insets(0, 0, 5, 0);
        gbc_tipoComboBox.gridx = 1;
        gbc_tipoComboBox.gridy = 0;
        panel.add(tipoComboBox, gbc_tipoComboBox);

        JLabel lblNewLabel_1 = new JLabel("Descrição:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

        descricaoTextArea = new JTextArea();
        descricaoTextArea.setRows(5); // Define o número de linhas exibidas
        descricaoTextArea.setLineWrap(true); // Habilita a quebra de linha automática
        JScrollPane scrollPane = new JScrollPane(descricaoTextArea); // Adiciona uma barra de rolagem
        GridBagConstraints gbc_descricaoTextArea = new GridBagConstraints();
        gbc_descricaoTextArea.insets = new Insets(0, 0, 5, 0);
        gbc_descricaoTextArea.fill = GridBagConstraints.BOTH;
        gbc_descricaoTextArea.gridx = 1;
        gbc_descricaoTextArea.gridy = 1;
        panel.add(scrollPane, gbc_descricaoTextArea);

        JButton enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) tipoComboBox.getSelectedItem();
                String descricao = descricaoTextArea.getText();

                Chamado chamado = new Chamado(tipo, descricao);
                ArmazenaChamado.salvarChamado(chamado);

                JOptionPane.showMessageDialog(frame, "Chamado aberto com sucesso!");
                descricaoTextArea.setText("");
            }
        });
        GridBagConstraints gbc_enviarButton = new GridBagConstraints();
        gbc_enviarButton.gridx = 1;
        gbc_enviarButton.gridy = 2;
        panel.add(enviarButton, gbc_enviarButton);

        List<String> tiposChamado = Arrays.asList("Hardware", "Software", "Telefonia Movel",
                "Telefonia Fixa", "Internet", "File Server");
        for (String tipo : tiposChamado) {
            tipoComboBox.addItem(tipo);
        }
    }

    public void show() {
        frame.setVisible(true);
    }
}
