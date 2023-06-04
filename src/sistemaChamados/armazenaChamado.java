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

    public Chamado getChamado(int codigo) {
        for (Chamado chamado : chamados) {
            if (chamado.getCodigo() == codigo) {
                return chamado;
            }
        }
        return null;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }
}