public class Ebook extends Livro implements Promocional {

    private String marcaDagua;

    // polimorfismo de sobrecarga (overload)

    public Ebook() {
        super(); // opcional
    }

    public Ebook(Autor autor) {
        // this.setAutor(autor);
        super(autor);
    }

    @Override
    public String getNome() {
        return this.getNome();
    }

    public String getMarcaDagua() {
        return marcaDagua;
    }

    public void setMarcaDagua(String marcaDagua) {
        this.marcaDagua = marcaDagua;
    }

    // polimorfismo de sobreposição (override)
    @Override
    public boolean aplicarDescontoDe(double porcentagem) {
        if (porcentagem > 0.15) {
            return false;
        }

        double desconto = this.getValor() * porcentagem;
        double novoValor = this.getValor() - desconto;
        this.setValor(novoValor);
        return true;

        // return super.aplicarDescontoDe(porcentagem);
    }

    @Override
    public String gerarCodigoBarras() {
        return this.getNome() + "-" + this.getValor() + "EBOOK";
    }

}
