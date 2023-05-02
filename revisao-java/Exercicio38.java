import java.util.Scanner;

public class Exercicio38 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número inteiro:");
        int numero = sc.nextInt();

        sc.close();

        if (numero == 1) {
            System.out.println("NÃO É PRIMO");
        } else {
            int contador = 0;

            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    contador++;
                }
            }

            if (contador == 2) {
                System.out.println("É PRIMO");
            } else {
                System.out.println("NÃO É PRIMO");
            }
        }

    }

}
