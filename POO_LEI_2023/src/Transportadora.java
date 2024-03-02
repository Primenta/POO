import java.text.DecimalFormat;
import java.util.Objects;

public class Transportadora {

    private String nome;
    private double valorBasePequenas;
    private double valorBaseMedias;
    private double valorBaseGrandes;
    private double factorImposto;
    private double margemLucro;
    private boolean especializadaPremium;

    public Transportadora () {
        this.nome = "";
        this.valorBasePequenas = 0;
        this.valorBaseMedias = 0;
        this.valorBaseGrandes = 0;
        this.factorImposto = 0;
        this.margemLucro = 0;
        this.especializadaPremium = false;
    }

    public Transportadora(String nome, double valorBasePequenas, double valorBaseMedias, double valorBaseGrandes, double factorImposto, double margemLucro, boolean especializadaPremium) {
        this.nome = nome;
        this.valorBasePequenas = valorBasePequenas;
        this.valorBaseMedias = valorBaseMedias;
        this.valorBaseGrandes = valorBaseGrandes;
        this.factorImposto = factorImposto;
        this.margemLucro = margemLucro;
        this.especializadaPremium = especializadaPremium;
    }

    public Transportadora(Transportadora transportadora) {
        this.nome = transportadora.nome;
        this.valorBasePequenas = transportadora.valorBasePequenas;
        this.valorBaseMedias = transportadora.valorBaseMedias;
        this.valorBaseGrandes = transportadora.valorBaseGrandes;
        this.factorImposto = transportadora.factorImposto;
        this.margemLucro = transportadora.margemLucro;
        this.especializadaPremium = transportadora.especializadaPremium;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorBasePequenas() {
        return valorBasePequenas;
    }
    public void setValorBasePequenas(double valorBasePequenas) {
        this.valorBasePequenas = valorBasePequenas;
    }

    public double getValorBaseMedias() {
        return valorBaseMedias;
    }
    public void setValorBaseMedias(double valorBaseMedias) {
        this.valorBaseMedias = valorBaseMedias;
    }

    public double getValorBaseGrandes() {
        return valorBaseGrandes;
    }
    public void setValorBaseGrandes(double valorBaseGrandes) {
        this.valorBaseGrandes = valorBaseGrandes;
    }

    public double getFactorImposto() {
        return factorImposto;
    }
    public void setFactorImposto(double factorImposto) {
        this.factorImposto = factorImposto;
    }

    public double getMargemLucro() {
        return margemLucro;
    }
    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public boolean getEspecializadaPremium() {
        return especializadaPremium;
    }
    public void setEspecializadaPremium(boolean especializadaPremium) { this.especializadaPremium = especializadaPremium; }


    public Transportadora clone() { return new Transportadora(this); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transportadora that = (Transportadora) o;
        return Double.compare(that.valorBasePequenas, valorBasePequenas) == 0 && Double.compare(that.valorBaseMedias, valorBaseMedias) == 0 && Double.compare(that.valorBaseGrandes, valorBaseGrandes) == 0 && Double.compare(that.factorImposto, factorImposto) == 0 && Double.compare(that.margemLucro, margemLucro) == 0 && especializadaPremium == that.especializadaPremium && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valorBasePequenas, valorBaseMedias, valorBaseGrandes, factorImposto, margemLucro, especializadaPremium);
    }


    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        StringBuilder sb = new StringBuilder("[Transportadora]\n")
                .append("Nome: ").append(nome).append("\n")
                .append("Valor Base Pequenas: ").append(df.format(this.valorBasePequenas)).append("\n")
                .append("Valor Base Grandes: ").append(df.format(this.valorBaseGrandes)).append("\n")
                .append("Valor Base Medias: ").append(df.format(this.valorBaseMedias)).append("\n")
                .append("Factor Imposto: ").append(df.format(this.factorImposto)).append("\n")
                .append("Margem de Lucro: ").append(df.format(this.margemLucro)).append("\n")
                .append("Premium: ").append(this.especializadaPremium).append("\n").append("\n");
        return sb.toString();
    }

    public double calcularPrecoExpedicao(int qtdArtigos, boolean premium) {
        double valorBase = 0;

        if (qtdArtigos == 1) {
            valorBase = this.valorBasePequenas;
        } else if (qtdArtigos >= 2 && qtdArtigos <= 5) {
            valorBase = this.valorBaseMedias;
        } else if (qtdArtigos > 5) {
            valorBase = this.valorBaseGrandes;
        }

        if (premium && this.especializadaPremium) {
            return (valorBase * this.margemLucro * (1 + this.factorImposto)) * 1.2; // Exemplo de cálculo, pode variar conforme a transportadora
        } else {
            return (valorBase * this.margemLucro * (1 + this.factorImposto)) * 0.9; // Exemplo de cálculo, pode variar conforme a transportadora
        }
    }

}
