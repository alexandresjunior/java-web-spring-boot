import java.util.Scanner;

public class CalculadoraDeEstoque2 {

    public static void main(String[] args) {
        // Uso do Scanner para entrada de dados pelo usuário via terminal
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o preço do livro de Java:");
        double livroJava = sc.nextDouble();

        System.out.println("Digite o preço do livro de Python:");
        double livroPython = sc.nextDouble();

        sc.close();

        double soma = livroJava + livroPython;

        if (soma < 150) {
            System.out.println("Seu estoque está muito baixo!");
        } else if (soma >= 2000) {
            System.out.println("Seu estoque está muito alto!");
        } else {
            System.out.println("Seu estoque está bom!");
        }

    }

}
