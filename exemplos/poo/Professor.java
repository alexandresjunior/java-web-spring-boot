public class Professor extends Usuario {

    private double horaAula;
    private String especialidade;
    private String titulacao;

    public double getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(double horaAula) {
        this.horaAula = horaAula;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public void fazerLogin() {
        System.out.println("O professor fez login!");
    }

}
