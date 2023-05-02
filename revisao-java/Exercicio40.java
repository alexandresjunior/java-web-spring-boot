import java.util.Scanner;

public class Exercicio40 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o tamanho do lado 1 do triângulo: ");
        int lado1 = sc.nextInt();

        System.out.println("Digite o tamanho do lado 2 do triângulo: ");
        int lado2 = sc.nextInt();

        System.out.println("Digite o tamanho do lado 3 do triângulo: ");
        int lado3 = sc.nextInt();

        sc.close();

        boolean formaTriangulo = (lado1 < lado2 + lado3)
                                && (lado2 < lado1 + lado3)
                                && (lado3 < lado1 + lado2);

        if (!formaTriangulo) {
            System.out.println("OS VALORES ENTRADOS NÃO FORMAM UM TRIÂNGULO");
        } else {
            if (lado1 == lado2 && lado1 == lado3 && lado2 == lado3) {
                System.out.println("EQUILÁTERO");
            } else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
                System.out.println("ESCALENO");
            } else {
                System.out.println("ISÓSCELES");
            }
        }

    }

}
