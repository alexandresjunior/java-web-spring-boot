public class MiniLivro extends Livro {

    @Override
    public String gerarCodigoBarras() {
        return this.getNome() + "-" + this.getValor();
    }

}
