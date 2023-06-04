package sistemaChamados;

public class Chamado {
    private String tipoChamado;
    private String descricao;

    public Chamado(String tipoChamado, String descricao) {
        this.tipoChamado = tipoChamado;
        this.descricao = descricao;
    }

    public String getTipoChamado() {
        return tipoChamado;
    }

    public String getDescricao() {
        return descricao;
    }
}