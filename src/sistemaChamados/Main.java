package sistemaChamados;

public class Main {

    public static void main(String[] args) {
        armazenaChamado armazenaChamado = new armazenaChamado();
        criarChamado criarChamado = new criarChamado(armazenaChamado);

        criarChamado.criarChamado();
        armazenaChamado.listarChamados();
    }
}
