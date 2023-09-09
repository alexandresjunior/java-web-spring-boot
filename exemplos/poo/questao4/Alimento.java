package questao4;
public class Alimento extends ItemDeLoja {

    private Integer selo;

    @Override
    public int getIdentificador() {
        return selo;
    }

    public Integer getSelo() {
        return selo;
    }

    public void setSelo(Integer selo) {
        this.selo = selo;
    }

}
