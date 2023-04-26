public class CarrinhoDeCompras {

    private double total;

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
    }

}
