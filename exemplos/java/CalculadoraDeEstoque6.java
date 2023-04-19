public class CalculadoraDeEstoque6 {

    public static void main(String[] args) {
        Livro livro = new Livro("Livro de Java");
        System.out.println(livro.nome);
        System.out.println(livro.descricao);

        Livro livro2 = new Livro("Livro de Python", "Descrição do livro 2");
        System.out.println(livro2.nome);
    }
    
}
