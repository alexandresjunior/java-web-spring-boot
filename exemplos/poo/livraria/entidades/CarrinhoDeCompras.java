package entidades;

import java.util.ArrayList;
import java.util.List;

import abstratas.Livro;
import interfaces.Produto;

public class CarrinhoDeCompras {

    private double total;
    private List<Produto> produtos = new ArrayList<>();

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // polimorfismo
    public void adiciona(Livro livro) {
        System.out.println("Adicionado: " + livro);
        this.total += livro.getValor();
        
        produtos.add(livro);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    


}
