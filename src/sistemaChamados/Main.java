package sistemaChamados;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Carregar chamados existentes
        List<Chamado> chamados = ArmazenaChamado.carregarChamados();

        ArmazenaChamado.salvarChamados(chamados);

        // Iniciar a interface de abertura de chamados
        CriarChamado criarChamado = new CriarChamado();
        criarChamado.show();
    }
}
