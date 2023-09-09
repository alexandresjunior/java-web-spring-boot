import java.util.Scanner;

public class TratamentoExcecoes {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sua idade:");
        int idade = sc.nextInt();

        sc.close();

        System.out.println("Você tem " + idade + " anos!");
    }

}
