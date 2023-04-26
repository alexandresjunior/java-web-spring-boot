public class RegraDeDesconto2 {
    
    public static void main(String[] args) {
        // Autor autor = new Autor();
        // autor.setNome("Alexandre");

        // Livro livro = new Livro("Java", null, 60, null);
        // System.out.println(livro.aplicarDescontoDe(0.20)); // true

        Ebook ebook = new Ebook();
        ebook.setValor(60);
        // System.out.println(ebook.aplicarDescontoDe(0.20)); // false
        // System.out.println(ebook.getAutor().getNome());

        LivroFisico lf = new LivroFisico();
        lf.setValor(50);
        // System.out.println(lf.obterTaxaImpressao());

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adiciona(ebook);
        carrinho.adiciona(lf);
        System.out.println(carrinho.getTotal());
    }

}
