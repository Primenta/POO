import java.util.Objects;

public class Venda {
    private Produto produto;
    private Utilizador vendedor;
    private Utilizador comprador;
    private double valorVenda;

    public Venda() {
        this.produto = null;
        this.vendedor = null;
        this.comprador = null;
        this.valorVenda = 0;
    }

    public Venda(Produto produto, Utilizador vendedor, Utilizador comprador, double valorVenda) {
        this.produto = produto;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.valorVenda = valorVenda;
    }

    public Venda(Venda venda) {
        this.produto = venda.produto;
        this.vendedor = venda.vendedor;
        this.comprador = venda.comprador;
        this.valorVenda = venda.valorVenda;
    }


    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Utilizador getVendedor() {
        return vendedor;
    }
    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }

    public Utilizador getComprador() {
        return comprador;
    }
    public void setComprador(Utilizador comprador) {
        this.comprador = comprador;
    }

    public double getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(double valorVenda) { this.valorVenda = valorVenda; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Double.compare(venda.valorVenda, valorVenda) == 0 && Objects.equals(produto, venda.produto) && Objects.equals(vendedor, venda.vendedor) && Objects.equals(comprador, venda.comprador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, vendedor, comprador, valorVenda);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "produto=" + produto +
                ", vendedor=" + vendedor +
                ", comprador=" + comprador +
                ", valorVenda=" + valorVenda +
                '}';
    }

    public Venda clone () { return new Venda(this); }
}
