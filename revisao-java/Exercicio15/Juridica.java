import java.util.Date;
import java.util.List;

public abstract class Juridica extends Pessoa {

    private String cnpj;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private Date fundacao;
    private List<Parceiro> parceiros;

    public Juridica() {

    }

    public Juridica(String cnpj, String nomeFantasia, String inscricaoEstadual, Date fundacao) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.fundacao = fundacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    public List<Parceiro> getParceiros() {
        return parceiros;
    }

    public void setParceiros(List<Parceiro> parceiros) {
        this.parceiros = parceiros;
    }

}
