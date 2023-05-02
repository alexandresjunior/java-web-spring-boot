import java.util.Scanner;

public class Exercicio49 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o peso do paciente (kg): ");
        double peso = sc.nextDouble();

        System.out.println("Digite a altura do paciente (m): ");
        double altura = sc.nextDouble();

        sc.close();

        double imc = peso / Math.pow(altura, 2);

        String situacao = "";

        if (imc < 20) {
            situacao = "Abaixo do peso";
        } else if (imc < 25) {
            situacao = "Peso normal";
        } else if (imc < 30) {
            situacao = "Sobrepeso";
        } else if (imc < 35) {
            situacao = "Obeso";
        } else {
            situacao = "Obeso mórbido";
        }

        System.out.println("IMC: " + imc + " - " + situacao);

    }

}
