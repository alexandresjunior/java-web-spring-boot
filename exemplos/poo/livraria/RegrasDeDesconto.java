public class RegrasDeDesconto {

    public static void main(String[] args) {
        Autor autor = new Autor();

        autor.setNome("Alexandre");
        autor.setEmail("alex@dev.com");
        autor.setCpf("123456789-00");

        Livro livro = new Livro("Livro de Java Web", 
            "Aprenda sobre linguagem Java", 
                59.90, 
                "123456-7890");

        livro.mostrarDetalhes("Detalhes do livro:");

        // System.out.println("Valor atual do livro: " + livro.getValor());

        // if (livro.aplicarDescontoDe(0.1)) {
        //     System.out.println("Valor com desconto: " + livro.getValor());
        // } else {
        //     System.out.println("Desconto não pode ser maior que 30%!");
        // }

    }
    
}
