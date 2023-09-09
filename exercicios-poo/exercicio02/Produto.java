package exercicio02;

import java.util.Date;

public class Produto {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Date validade;

    public Produto() {

    }

    public Produto(Integer id, String nome, String descricao, Date validade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
