package questao4;
public class Ferramenta extends ItemDeLoja {

    private String categoria;
    private int serial;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    @Override
    public int getIdentificador() {
        return serial;
    }

    public void separar() {
        setCategoria("Outros");
    }

    public void separar(String valor) {
        setCategoria(valor);
    }

}
