import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Aluno {

    private String nome;
    private String sobrenome;
    private String cpf;
    private Date dataNascimento;
    private int matricula;
    private static int numeroDeAlunos;

    public Aluno() {
        numeroDeAlunos++;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Métodos Customizados

    public void fazerLogin() {
        System.out.println("O aluno " + this.nome + " fez login!");
    }

    public void fazerLogin(String nome) {
        System.out.println("O aluno " + nome + " fez login!");
    }

    public void mostrarDetalhesDoAluno() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Sobrenome: " + this.sobrenome);
        System.out.println("Data de Nascimento: " + formatarData(this.dataNascimento));
        System.out.println("Matrícula: " + this.matricula);
    }

    private String formatarData(Date data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return df.format(data);
    }

    public static int getNumeroDeAlunos() {
        return numeroDeAlunos;
    }

    public static void setNumeroDeAlunos(int numeroDeAlunos) {
        Aluno.numeroDeAlunos = numeroDeAlunos;
    }

}
