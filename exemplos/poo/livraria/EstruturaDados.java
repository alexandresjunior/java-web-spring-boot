import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EstruturaDados {

    public static void main(String[] args) {
        // int[] vetor = new int[]{2, 3, 4, 5, 6};

        // System.out.println(vetor.length);

        // try {
        //     ArrayList<Integer> lista = new ArrayList<>();

        //     lista.add(2);

        //     System.out.println(lista.get(1));
        // } catch (IndexOutOfBoundsException | NullPointerException exception) {
        //     System.out.println("Erro no código!");
        //     exception.printStackTrace();
        // } finally {
        //     System.out.println("Programa finalizado!");
        // }

        try {
            FileInputStream file = new FileInputStream("arquivo.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
