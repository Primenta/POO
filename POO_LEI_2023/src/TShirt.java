import java.io.Serializable;

public class TShirt extends Produto implements Serializable {
    private String tamanho;
    private Padrao padrao;

    public TShirt(String descricao, String marca, String codigo, Estado estado, double precoBase, double correcaoPreco, String proprietario, String tamanho, Padrao padrao) {
        super(descricao, marca, codigo, estado, precoBase, correcaoPreco, proprietario);
        this.tamanho = tamanho;
        this.padrao = padrao;
    }

    public TShirt (TShirt tShirt) {
        super(tShirt);
        this.tamanho = tShirt.tamanho;
        this.padrao = tShirt.padrao;
    }

    public enum Padrao {
        LISO, RISCAS, PALMEIRAS
    }

    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Padrao getPadrao() {
        return padrao;
    }
    public void setPadrao(Padrao padrao) {
        this.padrao = padrao;
    }


    public double calculaPrecoFinal() {
        if (getPadrao() == Padrao.LISO) {
            return getPrecoBase();
        } else if (getEstado() == Estado.USADO && ((getPadrao() == Padrao.PALMEIRAS) || (getPadrao() == Padrao.RISCAS))) {
            return getPrecoBase() * 0.5;
        } else {
            return getPrecoBase();
        }
    }

    public TShirt clone() { return new TShirt(this); }

    @Override
    public String toString() {
        return "TShirt{" + super.toString() +
                "tamanho='" + tamanho + '\'' +
                ", padrao='" + padrao + '\'' +
                '}';
    }
}