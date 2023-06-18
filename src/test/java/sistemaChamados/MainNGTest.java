package sistemaChamados;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.JButton;

public class MainNGTest {
    private Main main;

    @BeforeMethod
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testLoginWithAdminCredentials() {
        // Arrange
        main.usernameTextField.setText("admin");
        main.passwordField.setText("admin");
        JButton loginButton = (JButton) main.frame.getContentPane().getComponent(1);

        // Act
        loginButton.doClick();

        // Assert
        // Assert the admin frame is opened or any other expected behavior
        Assert.assertEquals(main.frame.isVisible(), false);
    }

    @Test
    public void testLoginWithUserCredentials() {
        // Arrange
        main.usernameTextField.setText("user");
        main.passwordField.setText("user");
        JButton loginButton = (JButton) main.frame.getContentPane().getComponent(1);

        // Act
        loginButton.doClick();

        // Assert
        // Assert the user frame is opened or any other expected behavior
        Assert.assertEquals(main.frame.isVisible(), false);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        // Arrange
        main.usernameTextField.setText("invalid");
        main.passwordField.setText("invalid");
        JButton loginButton = (JButton) main.frame.getContentPane().getComponent(1);

        // Act
        loginButton.doClick();

        // Assert
        // Assert an error message is shown or any other expected behavior
        // For simplicity, I'm assuming the error message is displayed using JOptionPane
        Assert.assertEquals(JOptionPaneMock.getMessage(), "Usuário ou senha incorretos");
    }

    // Mocking JOptionPane to capture the message displayed
    public static class JOptionPaneMock {
        private static String message;

        public static void showMessageDialog(Object parentComponent, Object message) {
            JOptionPaneMock.message = (String) message;
        }

        public static String getMessage() {
            return message;
        }
    }
}
