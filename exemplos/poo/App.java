import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();

        aluno.setNome("Alex");

        // Manipulação de Data #1 - Usando a classe Date e SimpleDateFormat

        Date data = new Date();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            data = formato.parse("28/07/1995");

            aluno.setDataNascimento(data);
        } catch (ParseException e) {
            System.out.println("Não foi possível fazer a transformação String em Date");
        }

        // Manipulação de Datas #2: Usando a classe Calendar

        Calendar dataCalenda = new GregorianCalendar(1995, 6, 28);

        aluno.setDataNascimento(dataCalenda.getTime());
        
        System.out.println(dataCalenda.getTime());

        // Voltar para o formato dd/MM/yyyy

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String dataFormatada = df.format(data);

        System.out.println("Data sem formatação: " + data);
        System.out.println("Data Formatada: " + dataFormatada);
    }

}