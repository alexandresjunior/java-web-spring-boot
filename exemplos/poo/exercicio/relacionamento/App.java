import java.util.ArrayList;
import java.util.List;

public class App {
    
    public static void main(String[] args) {
        Empresa empresa = new Empresa();

        empresa.setNome("Treina Recife");
        empresa.setCpnj("123456789/0001-22");
        empresa.setArea("Educação e Tecnologia");

        Colaborador colaborador = new Colaborador();

        colaborador.setNome("Alexandre de Souza Jr.");
        colaborador.setCpf("123.456.789-00");

        List<Colaborador> colaboradores = new ArrayList<>();

        colaboradores.add(colaborador);

        empresa.setColaboradores(colaboradores);

        ////////////////////

        colaboradores.add(new Colaborador("Marcelo"));
        colaboradores.add(new Colaborador("Álvaro"));

        List<Colaborador> colaboradoresDaEmpresa = empresa.getColaboradores();

        for (Colaborador colaboradorDaEmpresa : colaboradoresDaEmpresa) {
            System.out.println(colaboradorDaEmpresa.getNome());
        }
    }
    
}
