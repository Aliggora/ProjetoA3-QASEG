package sistemaChamados;

public class Chamado {
    private String tipo;
    private String descricao;

    public Chamado(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
}
