package sistemaChamados;

import java.util.ArrayList;
import java.util.List;

public class armazenaChamado {
    private List<Chamado> chamados;

    public armazenaChamado() {
        chamados = new ArrayList<>();
    }

    public void adicionarChamado(Chamado chamado) {
        chamados.add(chamado);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void listarChamados() {
        for (Chamado chamado : chamados) {
            System.out.println("Tipo: " + chamado.getTipoChamado());
            System.out.println("Descrição: " + chamado.getDescricao());
            System.out.println("-----------------------");
        }
    }
}
