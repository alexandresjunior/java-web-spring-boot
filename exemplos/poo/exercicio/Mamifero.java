public class Mamifero extends Animal {

    private String alimento;

    public Mamifero(String nome, float comprimento, int numeroDePatas, String cor, String ambiente,
            float velocidadeMedia, String alimento) {
        super(nome, comprimento, numeroDePatas, cor, ambiente, velocidadeMedia);
        this.alimento = alimento;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }

    public void obterDados() {
        System.out.println("-------- Dados do Mamífero ---------");
        System.out.println("Alimento: " + this.alimento);
    }

    @Override
    public void respirar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void comer() {
        // TODO Auto-generated method stub
        
    }

}
