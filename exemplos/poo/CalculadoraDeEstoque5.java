public class CalculadoraDeEstoque5 {
    
    // Orientação a Objetos

    public static void main(String[] args) {
        
        Livro livro = new Livro();

        livro.nome = "Aprendendo a programar em Java";
        livro.descricao = "Novos recursos da linguagem";
        livro.valor = 59.90;
        livro.isbn = "978-85-6620-46-4";

        System.out.println(livro.autor); // null

        Autor autorDoLivro = new Autor();

        autorDoLivro.nome = "Alexandre Junior";
        autorDoLivro.email = "alexandre@gmail.com";
        autorDoLivro.cpf = "123456789-00";

        // livro.mostrarDetalhes();

        livro.autor = autorDoLivro; // referência ao objeto autorDoLivro

        // valores iguais
        System.out.println(autorDoLivro);
        System.out.println(livro.autor);

        System.out.println("Preço sem desconto: " + livro.valor);

        double novoValorDoLivro = livro.aplicarDescontoDe(0.1);

        System.out.println("Preço com desconto: " + novoValorDoLivro);

        // Livro outroLivro = new Livro();

        // outroLivro.nome = "Lógica de Programação com Python";
        // outroLivro.descricao = "Crie seus primeiros programas";
        // outroLivro.valor = 59.90;
        // outroLivro.isbn = "978-85-6620-22-0";

        // outroLivro.mostrarDetalhes();

        // Autor outroAutor = new Autor();

        // outroAutor.nome = "Rogério Aguiar";
        // outroAutor.email = "rogerio@treinarecife.com.br";
        // outroAutor.cpf = "123456789-01";

        // outroLivro.autor = outroAutor;

        // System.out.println(outroAutor);

    }

}
