public class LivroFisico extends Livro {

    public double obterTaxaImpressao() {
        return this.getValor() * 0.05;
    }
    
}
