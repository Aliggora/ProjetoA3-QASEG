package sistemaChamados;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ChamadoNGTest {
    private List<Chamado> chamados;

    @BeforeClass
    public void setUp() {
        chamados = new ArrayList<>();
        chamados.add(new Chamado(1, "Assunto 1", "Descrição 1", "Aberto", "Responsável 1"));
        chamados.add(new Chamado(2, "Assunto 2", "Descrição 2", "Fechado", "Responsável 2"));
    }

    @Test
    public void testLerChamados() throws CsvValidationException {
        List<Chamado> chamadosLidos = Chamado.lerChamados();
        Assert.assertEquals(chamadosLidos.size(), chamados.size(), "O número de chamados lidos está incorreto.");

        for (int i = 0; i < chamados.size(); i++) {
            Chamado chamadoLido = chamadosLidos.get(i);
            Chamado chamadoEsperado = chamados.get(i);

            Assert.assertEquals(chamadoLido.getId(), chamadoEsperado.getId(), "O ID do chamado lido está incorreto.");
            Assert.assertEquals(chamadoLido.getAssunto(), chamadoEsperado.getAssunto(), "O assunto do chamado lido está incorreto.");
            Assert.assertEquals(chamadoLido.getDescricao(), chamadoEsperado.getDescricao(), "A descrição do chamado lido está incorreta.");
            Assert.assertEquals(chamadoLido.getStatus(), chamadoEsperado.getStatus(), "O status do chamado lido está incorreto.");
            Assert.assertEquals(chamadoLido.getResponsavel(), chamadoEsperado.getResponsavel(), "O responsável do chamado lido está incorreto.");
        }
    }

    @Test
    public void testGravarChamados() throws CsvValidationException {
        Chamado.gravarChamados(chamados);

        List<Chamado> chamadosLidos = Chamado.lerChamados();
        Assert.assertEquals(chamadosLidos.size(), chamados.size(), "O número de chamados lidos após a gravação está incorreto.");

        for (int i = 0; i < chamados.size(); i++) {
            Chamado chamadoLido = chamadosLidos.get(i);
            Chamado chamadoEsperado = chamados.get(i);

            Assert.assertEquals(chamadoLido.getId(), chamadoEsperado.getId(), "O ID do chamado lido após a gravação está incorreto.");
            Assert.assertEquals(chamadoLido.getAssunto(), chamadoEsperado.getAssunto(), "O assunto do chamado lido após a gravação está incorreto.");
            Assert.assertEquals(chamadoLido.getDescricao(), chamadoEsperado.getDescricao(), "A descrição do chamado lido após a gravação está incorreta.");
            Assert.assertEquals(chamadoLido.getStatus(), chamadoEsperado.getStatus(), "O status do chamado lido após a gravação está incorreto.");
            Assert.assertEquals(chamadoLido.getResponsavel(), chamadoEsperado.getResponsavel(), "O responsável do chamado lido após a gravação está incorreto.");
        }
    }
}
