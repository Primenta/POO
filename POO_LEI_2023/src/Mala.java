import java.io.Serializable;
import java.time.LocalDate;

public class Mala extends Produto implements Serializable {
    private double dimensao;
    private String material;
    private int anoColecao;
    private boolean premium;

    public Mala(String descricao, String marca, String codigo, Estado estado, double precoBase, double correcaoPreco, String proprietario, double dimensao, String material, int anoColecao, boolean premium) {
        super(descricao, marca, codigo, estado, precoBase, correcaoPreco, proprietario);
        this.dimensao = dimensao;
        this.material = material;
        this.anoColecao = anoColecao;
        this.premium = premium;
    }

    public Mala(Mala mala) {
        super(mala);
        this.dimensao = mala.dimensao;
        this.material = mala.material;
        this.anoColecao = mala.anoColecao;
        this.premium = mala.premium;
    }

    public double getDimensao() {
        return dimensao;
    }
    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAnoColecao() {
        return anoColecao;
    }
    public void setAnoColecao(int anoColecao) {
        this.anoColecao = anoColecao;
    }

    public boolean isPremium() {
        return premium;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    /* Falta adicionar uma função que faça um desconto relativamente
       á dimensao da mala e o material usado */



    public double calculaPrecoFinal() {
        double desconto = (dimensao * 0.1) + (anoColecao * 0.05);
        if (premium) {
            double valorizacao = 0.1; // valorização de 10% ao ano
            desconto = -(valorizacao * (LocalDate.now().getYear() - anoColecao)); // considera-se o ano atual como 2023
        }
        return getPrecoBase() * (1 - desconto);
    }

    public Mala clone() {
        return new Mala(this);
    }

    @Override
    public String toString() {
        return "Mala{" + super.toString() +
                "dimensao=" + dimensao +
                ", material='" + material + '\'' +
                ", anoColecao=" + anoColecao +
                ", premium=" + premium +
                '}';
    }
}