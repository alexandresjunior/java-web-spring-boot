import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import entidades.Autor;
import entidades.CarrinhoDeCompras;
import entidades.Ebook;
import entidades.LivroFisico;
import exception.AutorNuloException;
import interfaces.Produto;

public class CadastroDeLivros {
    
    public static void main(String[] args) {
        // MiniLivro miniLivro = new MiniLivro();
        
        // boolean descontoFoiAplicado = miniLivro.aplicarDescontoDe(0.4);

        // System.out.println("O desconto foi aplicado?" + descontoFoiAplicado);
    
        // Date data1 = new Date();

        // // fully-qualified name

        // LivroFisico lf = new LivroFisico();
        // lf.setValor(10);

        // LivroFisico lf2 = new LivroFisico();
        // lf.setValor(20);
        
        // CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        // carrinho.adiciona(lf);
        // carrinho.adiciona(lf2);

        // Produto[] produtos = carrinho.getProdutos();

        // Produto produto1 = produtos[0];

        // List<Produto> produtos = carrinho.getProdutos();

        // Produto produto1 = produtos.get(2);

        // System.out.println(produto1); // null

        try {
            Ebook ebook = new Ebook(null);
        } catch (AutorNuloException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // executa no final sempre
        }

        
    }

}
