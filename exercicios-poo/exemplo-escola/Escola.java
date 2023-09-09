public class Escola {

    public static void main(String[] args) {

        Turma turma = new Turma();

        turma.setNome("Java Web com Spring Boot");
        turma.setPreco(400);
        turma.setCargaHoraria(48);

        turma.exibirInformacoes();

        Aluno aluno1 = new Aluno();

        aluno1.setNome("Raul Ramos");
        aluno1.setCpf("123.456.789-00");
        aluno1.setNota1(9);
        aluno1.setNota2(8);

        aluno1.exibirInformacoes();

        Aluno aluno2 = new Aluno("Karla Gisele");

        aluno2.setCpf("123.456.789-01");
        aluno2.setNota1(1);
        aluno2.setNota2(10);

        aluno2.exibirInformacoes();

        Aluno aluno3 = new Aluno("Vinícius Gutemberg", "123.456.789-02");

        aluno3.setNota1(3);
        aluno3.setNota2(10);

        aluno3.exibirInformacoes();

        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);

        turma.exibirInformacoes();
    }
    
}
