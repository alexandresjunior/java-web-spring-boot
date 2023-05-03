public class Parceiro {
    
    private String tipoPessoa;
    private double desempenho;
    private Fisica pessoaFisica;
    private Juridica pessoaJuridica;

    public Parceiro() {

    }

    public Parceiro(String tipoPessoa, double desempenho, Fisica pessoaFisica, Juridica pessoaJuridica) {
        this.tipoPessoa = tipoPessoa;
        this.desempenho = desempenho;
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public double getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(double desempenho) {
        this.desempenho = desempenho;
    }

    public Fisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(Fisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Juridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(Juridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public void bloquear() {
        System.out.println("Classe Parceiro - Método bloquear()");
    }

    public void cadastrar() {
        System.out.println("Classe Parceiro - Método cadastrar()");
    }

    public void excluir() {
        System.out.println("Classe Parceiro - Método excluir()");
    }

}
