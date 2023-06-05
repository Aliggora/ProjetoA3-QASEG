import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sistemaChamados.ArmazenaChamado;
import sistemaChamados.Chamado;

import java.util.List;

public class ArmazenaChamadoTest {

    @Test
    public void testSalvarChamado() {
        // Cria um chamado de teste
        Chamado chamado = new Chamado("Hardware", "Descrição do chamado de hardware");

        // Salva o chamado
        ArmazenaChamado.salvarChamado(chamado);

        // Carrega os chamados salvos
        List<Chamado> chamados = ArmazenaChamado.carregarChamados();

        // Verifica se o chamado de teste está presente na lista de chamados
        Assertions.assertTrue(chamados.contains(chamado));
    }

    @Test
    public void testCarregarChamados() {
        // Cria alguns chamados de teste
        Chamado chamado1 = new Chamado("Software", "Descrição do chamado de software");
        Chamado chamado2 = new Chamado("Internet", "Descrição do chamado de internet");

        // Salva os chamados
        ArmazenaChamado.salvarChamado(chamado1);
        ArmazenaChamado.salvarChamado(chamado2);

        // Carrega os chamados salvos
        List<Chamado> chamados = ArmazenaChamado.carregarChamados();

        // Verifica se os chamados de teste estão presentes na lista de chamados
        Assertions.assertTrue(chamados.contains(chamado1));
        Assertions.assertTrue(chamados.contains(chamado2));
    }

    @Test
    public void testSalvarChamados() {
        // Cria uma lista de chamados de teste
        List<Chamado> chamados = List.of(
                new Chamado("Hardware", "Descrição do chamado de hardware"),
                new Chamado("Software", "Descrição do chamado de software")
        );

        // Salva a lista de chamados
        ArmazenaChamado.salvarChamados(chamados);

        // Carrega os chamados salvos
        List<Chamado> carregados = ArmazenaChamado.carregarChamados();

        // Verifica se todos os chamados de teste estão presentes na lista de chamados carregados
        Assertions.assertTrue(carregados.containsAll(chamados));
    }
}
