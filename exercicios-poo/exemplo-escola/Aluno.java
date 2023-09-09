public class Aluno {

    private String nome;
    private String cpf;
    private String email;
    private int idade;
    private String matricula;
    private char genero;
    private double nota1;
    private double nota2;

    Aluno() {

    }

    Aluno(String nome) {
        this.nome = nome;
    }

    Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Aluno(String nome, String cpf, String email, int idade, String matricula, char genero, double nota1,
            double nota2) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.matricula = matricula;
        this.genero = genero;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean aprovado() {
        return calcularMedia() >= 7;
    }

    public void exibirInformacoes() {
        System.out.println("Exibindo informações do aluno:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Idade: " + idade);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Gênero: " + genero);
        System.out.println("Média: " + calcularMedia());
        System.out.println("Situação: " + (aprovado() ? "APROVADO" : "REPROVADO"));
        System.out.println("-----");
    }

}
