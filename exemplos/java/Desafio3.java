import java.util.Scanner;

public class Desafio3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String frase = sc.nextLine();

        sc.close();

        int contador = 0;

        frase = frase.toLowerCase(); // converte tudo para minúsculo
        frase = frase.toUpperCase(); // converte tudo para maiúsculo
        String[] palavras = frase.split(" ");

        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i]);
        }

        // for (int i = 0; i < frase.length(); i++) {
        //     char caracterAtual = frase.charAt(i);

        //     if (caracterAtual == 'A' || caracterAtual == 'a') {
        //         contador++;
        //     }
        // }

        // System.out.println("TOTAL DE A = " + contador);
    }

}
