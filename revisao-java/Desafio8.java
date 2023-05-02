import java.util.Scanner;

public class Desafio8 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o coeficiente a: ");
        int a = sc.nextInt();

        System.out.println("Digite o coeficiente b: ");
        int b = sc.nextInt();

        System.out.println("Digite o coeficiente c: ");
        int c = sc.nextInt();

        sc.close();

        double delta = Math.pow(b, 2) - 4 * a * c;

        double raiz1, raiz2;

        if (delta > 0) {
            raiz1 = (- b - Math.sqrt(delta)) / (2 * a);
            raiz2 = (- b + Math.sqrt(delta)) / (2 * a);

            System.out.println("X1 = " + raiz1);
            System.out.println("X2 = " + raiz2);
        } else if (delta == 0) {
            raiz1 = - b / 2 * a;

            System.out.println("X1 = X2 = " + raiz1);
        } else {
            System.out.println("RAÍZES INDETERMINADAS");
        }

    }

}