package sistemaChamados;


public class Chamado {    
    private int codigo;
    private String descricao;

    public Chamado(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
