import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Encomenda {
    private List<Produto> produtos;
    private String nomeVendedor;
    private String nomeComprador;
    private String nomeTransportadora;
    private Embalagem embalagem;
    private EstadoEncomenda estadoEncomenda;
    private double taxaNovo;
    private double taxaUsado;
    private double custoExpedicao;
    private DateFormat dataCriacao;
    private DateFormat dataExpedicao;

    public Encomenda() {
        this.produtos = new ArrayList<>();
        this.nomeVendedor = "";
        this.nomeComprador = "";
        this.nomeTransportadora = "";
        this.embalagem = null;
        this.estadoEncomenda = null;
        this.taxaNovo = 0.5;
        this.taxaUsado = 0.25;
        this.custoExpedicao = 0.0;
        this.dataCriacao = new SimpleDateFormat("dd/MM/yyyy");
        this.dataExpedicao = new SimpleDateFormat("dd/MM/yyyy");
    }

    public Encomenda (List<Produto> produtos, String nomeVendedor, String nomeComprador, String nomeTransportadora, Embalagem embalagem, EstadoEncomenda estadoEncomenda, double taxaNovo, double taxaUsado, double custoExpedicao, DateFormat dataCriacao, DateFormat dataExpedicao) {
        this.produtos = produtos;
        this.nomeVendedor = nomeVendedor;
        this.nomeComprador = nomeComprador;
        this.nomeTransportadora = nomeTransportadora;
        this.embalagem = embalagem;
        this.estadoEncomenda = estadoEncomenda;
        this.taxaNovo = taxaNovo;
        this.taxaUsado = taxaUsado;
        this.dataCriacao = dataCriacao;
        this.dataExpedicao = dataExpedicao;
        this.custoExpedicao = custoExpedicao;
    }

    public Encomenda (Encomenda encomenda) {
        this.produtos = encomenda.produtos;
        this.nomeVendedor = encomenda.nomeVendedor;
        this.nomeComprador = encomenda.nomeComprador;
        this.nomeTransportadora = encomenda.nomeTransportadora;
        this.embalagem = encomenda.embalagem;
        this.estadoEncomenda = encomenda.estadoEncomenda;
        this.taxaNovo = encomenda.taxaNovo;
        this.taxaUsado = encomenda.taxaUsado;
        this.dataCriacao = encomenda.dataCriacao;
        this.dataExpedicao = encomenda.dataExpedicao;
        this.custoExpedicao = encomenda.custoExpedicao;
    }

    public Encomenda(List<Produto> produtos, String nomeVendedor, String nomeComprador, String nomeTransportadora, Embalagem embalagem, EstadoEncomenda estadoEncomenda, double taxaNovo, double taxaUsado, double custoExpedicao, String dataCriacao, String dataExpedicao) {
        this.produtos = produtos;
        this.nomeVendedor = nomeVendedor;
        this.nomeComprador = nomeComprador;
        this.nomeTransportadora = nomeTransportadora;
        this.embalagem = embalagem;
        this.estadoEncomenda = estadoEncomenda;
        this.taxaNovo = taxaNovo;
        this.taxaUsado = taxaUsado;
        this.dataCriacao = new SimpleDateFormat("dd/MM/yyyy");
        this.dataExpedicao = new SimpleDateFormat("dd/MM/yyyy");
        this.custoExpedicao = custoExpedicao;
    }

    enum EstadoEncomenda {
        PENDENTE,FINALIZADA,ENTREGUE
    }

    enum Embalagem {
        GRANDE, MEDIA, PEQUENA
    }

    //gets
    public List<Produto> getProdutos() { return produtos; }
    public String getNomeComprador() { return nomeComprador; }
    public String getNomeVendedor() { return nomeVendedor; }
    public String getNomeTransportadora() { return nomeTransportadora; }
    public Embalagem getEmbalagem() { return embalagem; }
    public EstadoEncomenda getEstadoEncomenda() { return estadoEncomenda; }
    public double getTaxaNovo() { return taxaNovo; }
    public double getTaxaUsado() { return taxaUsado; }
    public DateFormat getDataCriacao() { return dataCriacao; }
    public DateFormat getDataExpedicao() { return dataExpedicao; }
    public double getCustoExpedicao() { return custoExpedicao; }

    //sets
    public void setProdutos (List<Produto> produtos) { this.produtos = produtos; }
    public void setNomeComprador(String nomeComprador) { this.nomeComprador = nomeComprador; }
    public void setNomeVendedor(String nomeVendedor) { this.nomeVendedor = nomeVendedor; }
    public void setNomeTransportadora(String nomeTransportadora) { this.nomeTransportadora = nomeTransportadora; }
    public void setEmbalagem (Embalagem embalagem) { this.embalagem = embalagem; }
    public void setEstadoEncomenda (EstadoEncomenda estadoEncomenda) { this.estadoEncomenda = estadoEncomenda; }
    public void setTaxaNovo (double taxaNovo) { this.taxaNovo = taxaNovo; }
    public void setTaxaUsado (double taxaUsado) { this.taxaUsado = taxaUsado; }
    public void setDataCriacao (SimpleDateFormat dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setDataExpedicao (SimpleDateFormat dataExpedicao) { this.dataExpedicao = dataExpedicao; }
    public void setCustoExpedicao (double custoExpedicao) { this.custoExpedicao = custoExpedicao; }

    public void adicionarProduto (Produto produto) {
        produtos.add(produto);
    }
    public void removerProduto (Produto produto) {
        produtos.remove(produto);
    }


    // Numero de produtos da encomenda

    public int numeroProdutos () {
        return this.produtos.size();
    }

    // Usei o getPrecoBase mas não tenho a certeza se é este que tem de ser usado
    public double calculaPrecoFinal () {
        double precoFinal = 0.0;
        for (Produto produto : produtos) {
            if (produto.getEstado() == Produto.Estado.NOVO) {
                precoFinal += produto.getPrecoBase() + taxaNovo;
            } else if (produto.getEstado() == Produto.Estado.USADO) {
                precoFinal += produto.getPrecoBase() + taxaUsado;
            }
        }
        return precoFinal + custoExpedicao;
    }

    // Verifica se já passaram 48h de a encomenda ter sido entregue
    public boolean verificarEntrega(String dataCriacaoStr) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataCriacao = df.parse(dataCriacaoStr);
            if (estadoEncomenda == EstadoEncomenda.ENTREGUE) {
                Date dataAtual = new Date();
                long diferencaMilissegundos = dataAtual.getTime() - dataCriacao.getTime();
                long diferencaDias = diferencaMilissegundos / (24 * 60 * 60 * 1000);
                return diferencaDias >= 2;
            } else {
                return false;
            }
        } catch (ParseException e) {
            // Se a string não puder ser convertida em uma data, lance uma exceção ou retorne false
            return false;
        }
    }


    // Devolve a encomenda
    public Encomenda devolverEncomenda(List<Produto> produtos, String nomeVendedor, String nomeComprador, String nomeTransportadora, Embalagem embalagem, EstadoEncomenda estadoEncomenda, double taxaNovo, double taxaUsado, SimpleDateFormat dataCriacao, SimpleDateFormat dataExpedicao, double custoExpedicao) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        String dataCriacaoStr = dateFormat.format(dataCriacao);
        if (!verificarEntrega(dataCriacaoStr)) return null;
        Encomenda encomenda = new Encomenda(produtos, nomeVendedor, nomeComprador, nomeTransportadora, embalagem, estadoEncomenda, taxaNovo, taxaUsado, custoExpedicao, dataCriacao, dataExpedicao);
        return encomenda;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encomenda encomenda = (Encomenda) o;
        return Double.compare(encomenda.taxaNovo, taxaNovo) == 0 && Double.compare(encomenda.taxaUsado, taxaUsado) == 0 && Double.compare(encomenda.custoExpedicao, custoExpedicao) == 0 && Objects.equals(produtos, encomenda.produtos) && Objects.equals(nomeVendedor, encomenda.nomeVendedor) && Objects.equals(nomeComprador, encomenda.nomeComprador) && Objects.equals(nomeTransportadora, encomenda.nomeTransportadora) && Objects.equals(embalagem, encomenda.embalagem) && estadoEncomenda == encomenda.estadoEncomenda && Objects.equals(dataCriacao, encomenda.dataCriacao) && Objects.equals(dataExpedicao, encomenda.dataExpedicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtos, nomeVendedor, nomeComprador, nomeTransportadora, embalagem, estadoEncomenda, taxaNovo, taxaUsado, custoExpedicao, dataCriacao, dataExpedicao);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
                "produtos=" + produtos +
                ", nomeVendedor='" + nomeVendedor + '\'' +
                ", nomeComprador='" + nomeComprador + '\'' +
                ", nomeTransportadora='" + nomeTransportadora + '\'' +
                ", embalagem=" + embalagem +
                ", estadoEncomenda=" + estadoEncomenda +
                ", taxaNovo=" + taxaNovo +
                ", taxaUsado=" + taxaUsado +
                ", custoExpedicao=" + custoExpedicao +
                ", dataCriacao=" + dataCriacao +
                ", dataExpedicao=" + dataExpedicao +
                '}';
    }

    public Encomenda clone() { return new Encomenda(this); }

}


