package entidades;

import abstratas.Livro;
import interfaces.Promocional;

public class LivroFisico extends Livro implements Promocional {

    public double obterTaxaImpressao() {
        mostrarDetalhes();
        return this.getValor() * 0.05;
    }

    @Override
    public boolean aplicarDescontoDe(double porcentagem) {
        if (porcentagem > 0.3) {
            return false;
        }

        double desconto = this.getValor() * porcentagem;
        double novoValor = this.getValor() - desconto;

        this.setValor(novoValor);

        return true;
    }

    @Override
    public String gerarCodigoBarras() {
        return this.getNome() + "-" + this.getValor() + "LF";
    }
    
}
