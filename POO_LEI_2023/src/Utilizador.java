import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utilizador implements Serializable {
    private String id;
    private String email;
    private String nome;
    private String morada;
    private String numFiscal;
    private List<Produto> produtosAVenda;
    private List<Produto> produtosVendidos;
    private List<Produto> produtosAdquiridos;


    public Utilizador() {
        this.id = "";
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.numFiscal = "";
        this.produtosAVenda =
        this.produtosAdquiridos = new ArrayList<>();
        this.produtosVendidos = new ArrayList<>();
    }

    public Utilizador(String id, String email, String nome, String morada, String numFiscal) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
    }

    public Utilizador(String id, String email, String nome, String morada, String numFiscal, List<Produto> produtosAVenda, List<Produto> produtosVendidos, List<Produto> produtosAdquiridos) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numFiscal = numFiscal;
        this.produtosAVenda = new ArrayList<>(produtosAVenda);
        this.produtosVendidos = new ArrayList<>(produtosVendidos);
        this.produtosAdquiridos = new ArrayList<>(produtosAdquiridos);
    }

    public Utilizador(Utilizador u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.numFiscal = u.getNumeroFiscal();
        this.produtosAVenda = new ArrayList<>();
        this.produtosVendidos = new ArrayList<>();
        this.produtosAdquiridos = new ArrayList<>();
    }

    public Utilizador(String nome) {
        this.id = "";
        this.email = "";
        this.nome = "";
        this.morada = "";
        this.numFiscal = "";
        this.produtosAVenda = new ArrayList<>();
        this.produtosVendidos = new ArrayList<>();
        this.produtosAdquiridos = new ArrayList<>();
    }
    /*
    public Utilizador(Utilizador utilizador) {
        this.email = utilizador.email;
        this.nome = utilizador.email;
        this.morada = utilizador.email;
        this.numFiscal = utilizador.email;
        this.produtosAVenda = new ArrayList<>(utilizador.produtosAVenda);
        this.produtosVendidos = new ArrayList<>(utilizador.produtosVendidos);
        this.produtosAdquiridos = new ArrayList<>(utilizador.produtosAdquiridos);
        this.vendasEfetuadas = new ArrayList<>(utilizador.vendasEfetuadas);
    }

    */

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNumeroFiscal() {
        return numFiscal;
    }
    public void setNumeroFiscal(String numeroFiscal) {
        this.numFiscal = numeroFiscal;
    }

    public List<Produto> getProdutosAVenda() {
        return produtosAVenda;
    }
    public void setProdutosAVenda(List<Produto> produtosAVenda) {
        this.produtosAVenda = produtosAVenda;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }
    public void setProdutosVendidos(List<Produto> produtosVendidos) {
        this.produtosVendidos = produtosVendidos;
    }

    public List<Produto> getProdutosAdquiridos() {
        return produtosAdquiridos;
    }
    public void setProdutosAdquiridos(List<Produto> produtosAdquiridos) { this.produtosAdquiridos = produtosAdquiridos; }


    public void adicionarProdutoAVenda(Produto produto) {
        this.produtosAVenda.add(produto);
    }
    public void removerProdutoAVenda(Produto produto) {
        this.produtosAVenda.remove(produto);
    }
    public void adicionarProdutoVendido(Produto produto) {
        this.produtosVendidos.add(produto);
    }
    public void adicionarProdutoAdquirido(Produto produto) {
        this.produtosAdquiridos.add(produto);
    }

    public double valorVendasEfetuadas (List<Venda> vendasEfetuadas) {
        double valorVendas = 0;

        for (Venda venda : vendasEfetuadas) {
            valorVendas += venda.getValorVenda();
        }

        return valorVendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(nome, that.nome) && Objects.equals(morada, that.morada) && Objects.equals(numFiscal, that.numFiscal) && Objects.equals(produtosAVenda, that.produtosAVenda) && Objects.equals(produtosVendidos, that.produtosVendidos) && Objects.equals(produtosAdquiridos, that.produtosAdquiridos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, nome, morada, numFiscal, produtosAVenda, produtosVendidos, produtosAdquiridos);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", numFiscal='" + numFiscal + '\'' +
                ", produtosAVenda=" + produtosAVenda +
                ", produtosVendidos=" + produtosVendidos +
                ", produtosAdquiridos=" + produtosAdquiridos +
                '}';
    }

    public Utilizador clone() { return new Utilizador(this); }

}





