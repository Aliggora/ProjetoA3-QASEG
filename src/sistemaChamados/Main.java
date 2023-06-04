package sistemaChamados;

public class Main {
    
    public static void main(String[] args) {
        armazenaChamado armazenaChamado = new armazenaChamado();

        Chamado chamado1 = new Chamado (1, "Problema no servidor");
        Chamado chamado2 = new Chamado(2, "Erro de conexao");
        Chamado chamado3 = new Chamado(3, "Aplicativo travado");

        armazenaChamado.adicionarChamado(chamado1);
        armazenaChamado.adicionarChamado(chamado2);
        armazenaChamado.adicionarChamado(chamado3);

        System.out.println("Lista de Chamados:");
        for (Chamado chamado : armazenaChamado.getChamados()) {
            System.out.println("Codigo: " + chamado.getCodigo());
            System.out.println("Descricao: " + chamado.getDescricao());
            System.out.println("-----------------------------");
        }

        int codigoBusca = 2;
        Chamado chamadoBusca = armazenaChamado.getChamado(codigoBusca);
        if (chamadoBusca != null) {
            System.out.println("Chamado encontrado (Ccdigo " + codigoBusca + "): " + chamadoBusca.getDescricao());
        } else {
            System.out.println("Chamado nao encontrado (Código " + codigoBusca + ")");
        }
    }
}
