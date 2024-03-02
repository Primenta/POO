import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private String descricao;
    private String marca;
    private String codigo;
    private Estado estado;
    private double precoBase;
    private double correcaoPreco;
    private String proprietario;

    public Produto() {
        this.descricao = null;
        this.marca = null;
        this.codigo = "";
        this.estado = null;
        this.precoBase = 0;
        this.correcaoPreco = 0;
        this.proprietario = "";
    }

    public Produto(Produto produto) {
        this.descricao = produto.descricao;
        this.marca = produto.marca;
        this.codigo = produto.codigo;
        this.estado = produto.estado;
        this.precoBase = produto.precoBase;
        this.correcaoPreco = produto.correcaoPreco;
        this.proprietario = produto.proprietario;
    }

    public Produto(String descricao, String marca, String codigo, Estado estado, double precoBase, double correcaoPreco, String proprietario) {
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = codigo;
        this.estado = estado;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.proprietario = proprietario;
    }

    public Produto(String produtoCodigo) {
        this.descricao = descricao;
        this.marca = marca;
        this.codigo = produtoCodigo;
        this.estado = estado;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.proprietario = proprietario;
    }

    public enum Estado {
        NOVO, USADO
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public double getPrecoBase() { return precoBase; }
    public void setPrecoBase(double precoBase) { this.precoBase = precoBase; }

    public double getCorrecacaoPreco() { return correcaoPreco; }
    public void setCorrecacaoPreco(double correcacaoPreco) { this.correcaoPreco = correcacaoPreco; }

    public String getProprietario() { return proprietario; }
    public void setProprietario(String proprietario) { this.proprietario = proprietario; }


    public void aplicarCorrecacaoPreco(double correcao) {
        this.correcaoPreco = correcao;
    }

    public double calcularPrecoFinal() {
        return this.precoBase * (1 - this.correcaoPreco);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Double.compare(produto.precoBase, precoBase) == 0 && Double.compare(produto.correcaoPreco, correcaoPreco) == 0 && Objects.equals(descricao, produto.descricao) && Objects.equals(marca, produto.marca) && Objects.equals(codigo, produto.codigo) && Objects.equals(estado, produto.estado) && Objects.equals(proprietario, produto.proprietario);
    }

    public int hashCode() {
        return Objects.hash(descricao, marca, codigo, estado, precoBase, correcaoPreco, proprietario);
    }

    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", codigo='" + codigo + '\'' +
                ", estado='" + estado + '\'' +
                ", precoBase=" + precoBase +
                ", correcaoPreco=" + correcaoPreco +
                ", proprietario=" + proprietario +
                '}';
    }

    public Produto clone () { return new Produto(this); }

}
