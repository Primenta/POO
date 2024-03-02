import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fatura implements Serializable {
    private String nomeVendedor;
    private String nomeComprador;
    private String nomeTransportadora;
    private List<Produto> produtos;
    private double precoTotal;

    public Fatura() {
        this.nomeComprador = "";
        this.nomeVendedor = "";
        this.nomeTransportadora = "";
        this.produtos = new ArrayList<>();
        this.precoTotal = 0.0;
    }

    public Fatura(String nomeComprador, String nomeVendedor, String nomeTransportadora, List<Produto> produtos, double precoTotal) {
        this.nomeComprador = nomeComprador;
        this.nomeVendedor = nomeVendedor;
        this.nomeTransportadora = nomeTransportadora;
        this.produtos = produtos;
        this.precoTotal = precoTotal;
    }

    public Fatura(Fatura f) {
        this.nomeComprador = f.getNomeComprador();
        this.nomeVendedor = f.getNomeVendedor();
        this.nomeTransportadora = f.getNomeTransportadora();
        this.produtos = f.getProdutos();
        this.precoTotal = f.getPrecoTotal();
    }

    public String getNomeComprador() {
        return nomeComprador;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public String getNomeTransportadora() {
        return nomeTransportadora;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setNomeComprador(String nomeComprador) {
        this.nomeComprador = nomeComprador;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public void setNomeTransportadora(String nomeTransportadora) {
        this.nomeTransportadora = nomeTransportadora;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "nomeVendedor='" + nomeVendedor + '\'' +
                ", nomeComprador='" + nomeComprador + '\'' +
                ", nomeTransportadora='" + nomeTransportadora + '\'' +
                ", produtos=" + produtos +
                ", precoTotal=" + precoTotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fatura fatura = (Fatura) o;
        return Double.compare(fatura.precoTotal, precoTotal) == 0 && Objects.equals(nomeVendedor, fatura.nomeVendedor) && Objects.equals(nomeComprador, fatura.nomeComprador) && Objects.equals(nomeTransportadora, fatura.nomeTransportadora) && Objects.equals(produtos, fatura.produtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeVendedor, nomeComprador, nomeTransportadora, produtos, precoTotal);
    }

    public Fatura clone() { return new Fatura(this); }
}
