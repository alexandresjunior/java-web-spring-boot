public class CadastroDeTransportes {
    
    public static void main(String[] args) {
        
        Transporte carro = new Transporte(1, 2000, "Uno", 500.0, 50.0);

        System.out.println(carro.consumo());

    }

}
