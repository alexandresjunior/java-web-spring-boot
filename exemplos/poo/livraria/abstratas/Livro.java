package abstratas;

import entidades.Autor;
import exception.AutorNuloException;
import interfaces.Produto;

public abstract class Livro implements Produto {

    // default, public, private, protected
    
    // Atributos

    private String nome;
    private String descricao;
    private double valor;
    private String isbn;
    private Autor autor; // composição de classes

    // Overload (Sobrecarga)

    public Livro() {
    }

    public Livro(Autor autor) throws AutorNuloException {
        if (autor != null) {
            this.autor = autor;
        } else {
            throw new AutorNuloException("Autor nulo!");
        }
        
    }

    // Métodos

    public Livro(String nome, String descricao, double valor, String isbn) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.isbn = isbn;
    }

    protected void mostrarDetalhes(String mensagem) {
        System.out.println(mensagem);
        System.out.println(nome);
        System.out.println(descricao);
        System.out.println(valor);
        System.out.println(isbn);

        if (temAutor()) {
            autor.mostrarDetalhes(); // NullPointerException
        }

        System.out.println("---");
    }

    protected void mostrarDetalhes() {
        String mensagem = "Mostrando detalhes do livro:";
        System.out.println(mensagem);
        System.out.println(nome);
        System.out.println(descricao);
        System.out.println(valor);
        System.out.println(isbn);

        if (temAutor()) {
            autor.mostrarDetalhes(); // NullPointerException
        }

        System.out.println("---");
    }

    public String getNome() {
        return this.nome;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    boolean temAutor() {
        return this.autor != null;
    }

}
