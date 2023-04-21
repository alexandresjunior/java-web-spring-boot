public class Livro {

    // default, public, private, protected
    
    // Atributos

    private String nome;
    private String descricao;
    private double valor;
    private String isbn;
    private Autor autor; // composição de classes

    // Overload (Sobrecarga)

    Livro() {

    }

    Livro(Autor autor) {
        this.autor = autor;
    }

    // Métodos

    public Livro(String nome, String descricao, double valor, String isbn) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.isbn = isbn;
    }

    void mostrarDetalhes(String mensagem) {
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

    void mostrarDetalhes() {
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

    boolean aplicarDescontoDe(double valor) {
        if (valor > 0.3) {
            return false;
        }

        this.valor -= this.valor * valor;

        return true;
    }

}
