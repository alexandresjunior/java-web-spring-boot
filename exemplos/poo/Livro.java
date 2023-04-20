public class Livro {
    
    // Atributos

    String nome;
    String descricao;
    double valor;
    String isbn;
    Autor autor; // composição de classes

    Livro() {

    }

    Livro(String nome) {
        this.nome = nome;
    }

    Livro(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Métodos

    void mostrarDetalhes() {
        String mensagem = "Mostrando detalhes do livro:";
        System.out.println(mensagem);
        System.out.println(nome);
        System.out.println(descricao);
        System.out.println(valor);
        System.out.println(isbn);

        if (temAutor()) {
            autor.mostrarDetalhes();
        }

        System.out.println("---");
    }

    boolean temAutor() {
        return this.autor != null;
    }

    double aplicarDescontoDe(double valor) {
        this.valor -= this.valor * valor;

        return this.valor;
    }

    

}
