public class Loops {

    public static void main(String[] args) {
        
        double soma = 0;
        int contador = 0;

        // do {
        //     double livro = 59.90;

        //     soma = soma + livro;

        //     contador = contador + 1;
        // } while (contador < 35);

        // while (contador < 35) {
        //     double livro = 59.90;

        //     soma += livro;

        //     contador++;

        //     if (soma > 1500) {
        //         break;
        //     }
        // }

        for (int i = 0; i < 35; i++) {
            double livro = 59.90;

            if (i % 2 != 0) {
                continue;
            }

            soma += livro;

            if (soma > 1000) {
                contador = i;
                break;
            }
        }

        System.out.println("Qtd de livros: " + contador);
        System.out.printf("Total do estoque: %.2f", soma);

        // Operadores lógicos AND (&&) e OR (||)
        if (soma < 150 || soma >= 2000) {
            System.out.println("Seu estoque está fora do normal!");
        } else if (soma >= 150 && soma < 2000) {
            System.out.println("Seu estoque está bom!");
        }


    }
    
}
