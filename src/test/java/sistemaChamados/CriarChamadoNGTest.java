package sistemaChamados;

import org.testng.annotations.Test;
import javax.swing.*;
import static org.testng.Assert.*;

public class CriarChamadoNGTest {

    @Test
    public void testCriarButtonActionPerformed() {
        CriarChamado criarChamado = new CriarChamado();
        criarChamado.show();

        JTextField assuntoTextField = criarChamado.getAssuntoTextField();
        JTextArea descricaoTextArea = criarChamado.getDescricaoTextArea();
        JButton criarButton = criarChamado.getCriarButton();

        SwingUtilities.invokeLater(() -> {
            assuntoTextField.setText("Assunto do chamado");
            descricaoTextArea.setText("Descrição do chamado");

            criarButton.doClick();

            JOptionPane pane = (JOptionPane) JOptionPane.getRootFrame().getComponent(1);
            String message = (String) pane.getMessage();
            assertEquals("Chamado criado com sucesso!", message);

            criarChamado.getFrame().dispose();
        });
    }
}
