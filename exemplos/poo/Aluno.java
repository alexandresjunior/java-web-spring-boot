public class Aluno extends Usuario {

    private String matricula;
    private double nota;
    private boolean ativo;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void fazerLogin() {
        System.out.println("O aluno fez login!");
    }

    public void fazerLogin(String qualquerCoisa) {
        System.out.println(qualquerCoisa);
    }

}
