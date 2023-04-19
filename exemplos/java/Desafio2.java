import java.util.Scanner;

public class Desafio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de N: ");
        double n = scanner.nextDouble();

        scanner.close();

        double num = n;
        double den = 1;
        double soma = 0;

        // forma alternativa para o critério de parada
        // while (den <= n)

        while (num >= 1) {
            soma += num / den;

            // atualização o numerador e denominador
            num--;
            den++;
        }

        // System.out.println("A = " + soma);
        System.out.printf("A = %.2f", soma);
    }

}
