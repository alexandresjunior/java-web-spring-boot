public class Peixe extends Animal {

    private String caracteristica;

    public Peixe(String nome, float comprimento, int numeroDePatas, String cor, String ambiente,
    float velocidadeMedia, String caracteristica) {
        super(nome, comprimento, numeroDePatas, cor, ambiente, velocidadeMedia);
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public void obterDados() {
        System.out.println("-------- Dados do Peixe ---------");
        System.out.println("Nome: " + super.getNome());
        System.out.println("Comprimento: " + super.getComprimento());
        System.out.println("Característica: " + this.caracteristica);
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
