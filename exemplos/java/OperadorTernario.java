public class OperadorTernario {

    public static void main(String[] args) {
        int idade = 20;

        // String mensagem = "";

        // if (idade >= 18) {
        //     mensagem = "É maior de idade!";
        // } else {
        //     mensagem = "É menor de idade!";
        // }

        String mensagem = (idade >= 18) ? "É maior de idade!" : "É menor de idade!";

        System.out.println(mensagem);
    }

}
