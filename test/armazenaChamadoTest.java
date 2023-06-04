import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaChamados.Chamado;
import sistemaChamados.armazenaChamado;

public class armazenaChamadoTest {

    private armazenaChamado armazenaChamado;

    @BeforeEach
    public void setUp() {
        armazenaChamado = new armazenaChamado();
    }

    @Test
    public void testAdicionarChamado() {
        Chamado chamado = new Chamado("Hardware", "Problema no monitor");
        armazenaChamado.adicionarChamado(chamado);

        Assertions.assertEquals(1, armazenaChamado.getChamados().size());
        Assertions.assertTrue(armazenaChamado.getChamados().contains(chamado));
    }

    @Test
    public void testListarChamados() {
        Chamado chamado1 = new Chamado("Sistema Operacional", "Erro de inicialização");
        Chamado chamado2 = new Chamado("Software", "Crash do aplicativo");
        armazenaChamado.adicionarChamado(chamado1);
        armazenaChamado.adicionarChamado(chamado2);

        String expectedOutput = "Tipo: Sistema Operacional\n" +
                "Descrição: Erro de inicializacao\n" +
                "-----------------------\n" +
                "Tipo: Software\n" +
                "Descrição: Crash do aplicativo\n" +
                "-----------------------\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        armazenaChamado.listarChamados();

        String actualOutput = outputStream.toString();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
