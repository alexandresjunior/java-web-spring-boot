public class Exercicio15 {
    
    public static void main(String[] args) {
        Colaborador colaborador = new Colaborador();

        colaborador.admitir();

        Parceiro parceiro = new Parceiro();
        parceiro.setPessoaFisica(colaborador);

        parceiro.cadastrar();
    }

}
