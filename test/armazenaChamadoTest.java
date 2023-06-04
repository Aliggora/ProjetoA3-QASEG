import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sistemaChamados.Chamado;
import sistemaChamados.armazenaChamado;

public class armazenaChamadoTest {

    private armazenaChamado armazenaChamado;

    @BeforeEach
    public void setup() {
        armazenaChamado = new armazenaChamado();
    }

    @Test
    public void testAdicionarChamado() {
        Chamado chamado = new Chamado(1, "Problema no servidor");
        armazenaChamado.adicionarChamado(chamado);
        Assertions.assertEquals(1, armazenaChamado.getChamados().size());
    }

    @Test
    public void testGetChamadoExistente() {
        Chamado chamado = new Chamado(1, "Problema no servidor");
        armazenaChamado.adicionarChamado(chamado);
        Chamado chamadoRetornado = armazenaChamado.getChamado(1);
        Assertions.assertEquals(chamado, chamadoRetornado);
    }

    @Test
    public void testGetChamadoNaoExistente() {
        Chamado chamado = armazenaChamado.getChamado(1);
        Assertions.assertNull(chamado);
    }
}