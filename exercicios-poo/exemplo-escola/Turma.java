import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String nome;
    private double preco;
    private int cargaHoraria;
    private List<Aluno> alunos;

    Turma() {
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void exibirInformacoes() {
        System.out.println("Exibindo informações da turma:");
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Carga Horária: " + cargaHoraria);
        System.out.println("Qtde de alunos: " + obterQuantidadeAlunos());
        System.out.println("-----");
    }

    public double calcularPrecoHora() {
        return preco / cargaHoraria;
    }

    public int obterQuantidadeAlunos() {
        return this.alunos.size();
    }

    public List<Aluno> adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);

        return this.alunos;
    }

}