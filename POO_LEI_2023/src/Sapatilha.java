import java.io.Serializable;
import java.time.LocalDate;

public class Sapatilha extends Produto implements Serializable {
    private int tamanho;
    private boolean possuiAtacadores;
    private String cor;
    private int anoColecao;
    private boolean premium;
    private boolean isUsado;
    private int numeroDonos;
    private double estadoUtilizacao;

    public Sapatilha() {
        this.tamanho = 0;
        this.possuiAtacadores = false;
        this.cor = null;
        this.anoColecao = 0;
        this.premium = false;
        this.isUsado = false;
        this.numeroDonos = 1;
        this.estadoUtilizacao = 0.0;
    }

    public Sapatilha(String descricao, String marca, String codigo, Estado estado, double precoBase, double correcaoPreco, String proprietario, int tamanho, boolean possuiAtacadores, String cor, int anoColecao, boolean premium, boolean isUsado, int numeroDonos, double estadoUtilizacao) {
        super(descricao, marca, codigo, estado, precoBase, correcaoPreco, proprietario);
        this.tamanho = tamanho;
        this.possuiAtacadores = possuiAtacadores;
        this.cor = cor;
        this.anoColecao = anoColecao;
        this.premium = premium;
        this.isUsado = isUsado;
        this.numeroDonos = numeroDonos;
        this.estadoUtilizacao = estadoUtilizacao;
    }

    public Sapatilha (Sapatilha sapatilha) {
        super(sapatilha);
        this.tamanho = sapatilha.tamanho;
        this.possuiAtacadores = sapatilha.possuiAtacadores;
        this.cor = sapatilha.cor;
        this.anoColecao = sapatilha.anoColecao;
        this.premium = sapatilha.premium;
        this.isUsado = sapatilha.isUsado;
        this.numeroDonos = sapatilha.numeroDonos;
        this.estadoUtilizacao = sapatilha.estadoUtilizacao;
    }

    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho (int tamanho) { this.tamanho = tamanho; }

    public boolean isPossuiAtacadores() {
        return possuiAtacadores;
    }
    public void setPossuiAtacadores (boolean possuiAtacadores) { this.possuiAtacadores = possuiAtacadores;}

    public String getCor() {
        return cor;
    }
    public void setCor (String cor) { this.cor = cor; }

    public int getAnoColecao() {
        return anoColecao;
    }
    public void setAnoColecao (int anoColecao) { this.anoColecao = anoColecao; }

    public boolean isPremium() {
        return premium;
    }
    public void setPremium (boolean premium) { this.premium = premium; }

    public boolean isUsado() { return isUsado; }
    public void setUsado (boolean usado) { this.isUsado = usado;}

    public int getNumeroDonos() { return numeroDonos; }
    public void setNumeroDonos (int numeroDonos) { this.numeroDonos = numeroDonos; }

    public double getEstadoUtilizacao() { return estadoUtilizacao; }
    public void setEstadoUtilizacao (double estadoUtilizacao) { this.estadoUtilizacao = estadoUtilizacao; }


    public double calcularPreco() {
        double preco = getPrecoBase();

        if (isPremium()) {
            // Acrescentar aqui uma conta para aumentar o preco. !!! Resposta: fiz um aumento de 0,01 a cada ano que passe
            int numerodeAnos = LocalDate.now().getYear() - getAnoColecao();
            preco = preco + preco * numerodeAnos * 0.01;
        } else if (getAnoColecao() != LocalDate.now().getYear()) {
            // Desconto para sapatilhas antigas
            preco = preco - (preco / getNumeroDonos() * getEstadoUtilizacao());
        } else if (isUsado() || getTamanho() > 45) {
            // Desconto para sapatilhas usadas e/ou acima do tamanho 45
            preco = preco - (preco * 0.2);
        }

        return preco;
    }

    public Sapatilha clone() { return new Sapatilha(this); }

    @Override
    public String toString() {
        return "Sapatilha{" + super.toString() +
                "tamanho=" + tamanho +
                ", possuiAtacadores=" + possuiAtacadores +
                ", cor='" + cor + '\'' +
                ", anoColecao=" + anoColecao +
                ", premium=" + premium +
                ", isUsado=" + isUsado +
                ", numeroDonos=" + numeroDonos +
                ", estadoUtilizacao=" + estadoUtilizacao +
                '}';
    }
}