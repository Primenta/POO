import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;

public class Sys implements Serializable {

    private Map<String,Utilizador> utilizador;
    private Map<String,Transportadora> transportadora;
    private Map<String,Produto> produtos;
    private List<Encomenda> encomendas;
    private List<Fatura> faturas;
    private int id;

    public Sys() {

        this.utilizador = new HashMap<>();
        this.transportadora = new HashMap<>();
        this.produtos = new HashMap<>();
        this.encomendas = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.id = 0;
    }

    public Sys(Map<String,Utilizador> listaU, Map<String,Transportadora> listaT, Map<String, Produto> listaP, Set<Encomenda> encomendas, Set<Fatura> faturas) {

        this.utilizador = new HashMap<>();
        for (Utilizador u: listaU.values()) {
            this.utilizador.put(u.getId(),u.clone());
        }
        this.transportadora = new HashMap<>();
        for (Transportadora t : listaT.values()) {
            this.transportadora.put(t.getNome(),t.clone());
        }
        this.produtos = new HashMap<>();
        for (Produto p : listaP.values()) {
            this.produtos.put(p.getCodigo(),p.clone());
        }
        this.encomendas = new ArrayList<>();
        for (Encomenda e : encomendas) {
            this.encomendas.add(e.clone());
        }
        this.faturas = new ArrayList<>();
        for (Fatura f: faturas) {
            this.faturas.add(f.clone());
        }
    }

    public Sys(Sys s) {

        this.utilizador = s.getUtilizador();
        this.transportadora = s.getTransportadora();
        this.produtos = s.getProdutos();
        this.encomendas = s.getEncomenda();
        this.faturas = s.getFaturas();

    }

    public Map<String, Utilizador> getUtilizador() {
        Map<String,Utilizador> res = new HashMap<>();
        for(Map.Entry<String,Utilizador> utl : this.utilizador.entrySet()) {
            res.put(utl.getKey(),utl.getValue().clone());
        }
        return res;
    }

    public void setUtilizador(Map<String,Utilizador> res) {
        this.utilizador = new HashMap<>();
        for (Map.Entry<String,Utilizador> utl : res.entrySet()) {
            this.utilizador.put(utl.getKey(),utl.getValue().clone());
        }
    }

    public Map<String, Transportadora> getTransportadora() {
        Map<String,Transportadora> res = new HashMap<>();
        for(Map.Entry<String,Transportadora> trp : this.transportadora.entrySet()) {
            res.put(trp.getKey(),trp.getValue().clone());
        }
        return res;
    }

    public void setTransportadora(Map<String,Transportadora> res) {
        this.transportadora = new HashMap<>();
        for (Map.Entry<String,Transportadora> trp : res.entrySet()) {
            this.transportadora.put(trp.getKey(),trp.getValue().clone());
        }
    }

    public Map<String, Produto> getProdutos() {
        Map<String,Produto> res = new HashMap<>();
        for(Map.Entry<String,Produto> prd : this.produtos.entrySet()) {
            res.put(prd.getKey(),prd.getValue().clone());
        }
        return res;
    }

    public void setProdutos(Map<String,Produto> res) {
        this.produtos = new HashMap<>();
        for (Map.Entry<String,Produto> trp : res.entrySet()) {
            this.produtos.put(trp.getKey(),trp.getValue().clone());
        }
    }

    public List<Encomenda> getEncomenda() {
        List<Encomenda> res = new ArrayList<>();
        for (Encomenda enc : this.encomendas) {
            res.add(enc.clone());
        }
        return res;
    }

    public void setEncomenda (List<Encomenda> res) {
        this.encomendas = new ArrayList<>();
        for (Encomenda enc : res) {
            this.encomendas.add(enc.clone());
        }
    }

    public List<Fatura> getFaturas() {
        List<Fatura> res = new ArrayList<>();
        for (Fatura f : this.faturas) {
            res.add(f.clone());
        }
        return res;
    }

    public void setFaturas(List<Fatura> res) {
        this.faturas = new ArrayList<>();
        for (Fatura f : res) {
            this.faturas.add(f.clone());
        }
    }

    public int getId() { return this.id; }

    public void setId() { this.id++; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sys sys = (Sys) o;
        return id == sys.id && Objects.equals(utilizador, sys.utilizador) && Objects.equals(transportadora, sys.transportadora) && Objects.equals(produtos, sys.produtos) && Objects.equals(encomendas, sys.encomendas) && Objects.equals(faturas, sys.faturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilizador, transportadora, produtos, encomendas, faturas, id);
    }

    public void addTransportadora(String s, Transportadora t) {
        this.transportadora.put(s,t.clone());
    }

    public void addUtilizador(String s, Utilizador u) {
        this.utilizador.put(s,u.clone());
    }

    public void addProduto(String s, Produto t) {
        String s1 = s.toString();
        this.produtos.put(s1,t.clone());
    }

    public void addEncomenda(Encomenda e) { this.encomendas.add(e); }

    public void novoUtilizador(String[] novoUtilizador) {
        Utilizador u = new Utilizador();
        u.setId(novoUtilizador[0]);
        u.setEmail(novoUtilizador[1]);
        u.setNome(novoUtilizador[2]);
        u.setMorada(novoUtilizador[3]);
        u.setNumeroFiscal(novoUtilizador[4]);
        this.utilizador.put(u.getId(),u.clone());
    }

    public void novoProduto(String[] novoProduto) {
        Produto p = new Produto();
        p.setDescricao(novoProduto[0]);
        p.setMarca(novoProduto[1]);
        p.setCodigo(novoProduto[2]);
        p.setEstado(Produto.Estado.valueOf(novoProduto[3]));
        p.setPrecoBase(Double.parseDouble(novoProduto[4]));
        p.setCorrecacaoPreco(Double.parseDouble(novoProduto[5]));
        p.setProprietario(novoProduto[6]);
        this.produtos.put(p.getCodigo(),p.clone());
    }

    public void novaTransportadora(String[] novaTransportadora) {
        Transportadora t = new Transportadora();
        t.setNome(novaTransportadora[0]);
        t.setValorBasePequenas(Double.parseDouble(novaTransportadora[1]));
        t.setValorBaseMedias(Double.parseDouble(novaTransportadora[2]));
        t.setValorBaseGrandes(Double.parseDouble(novaTransportadora[3]));
        t.setMargemLucro(Double.parseDouble(novaTransportadora[4]));
        t.setEspecializadaPremium(Boolean.parseBoolean(novaTransportadora[5]));
        this.transportadora.put(t.getNome(),t.clone());
    }

    public void novaEncomenda(String[] novaEncomenda, List<Produto> produtos, SimpleDateFormat dataCriacao, SimpleDateFormat dataExpedicao) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Encomenda e = new Encomenda();
        e.setProdutos(produtos);
        e.setNomeVendedor(novaEncomenda[0]);
        e.setNomeComprador(novaEncomenda[1]);
        e.setNomeTransportadora(novaEncomenda[2]);
        e.setEmbalagem(Encomenda.Embalagem.valueOf(novaEncomenda[3]));
        e.setEstadoEncomenda(Encomenda.EstadoEncomenda.valueOf(novaEncomenda[4]));
        e.setTaxaNovo(Double.parseDouble(novaEncomenda[5]));
        e.setTaxaUsado(Double.parseDouble(novaEncomenda[6]));
        e.setCustoExpedicao(Double.parseDouble(novaEncomenda[7]));
        e.setDataCriacao(dataCriacao);
        e.setDataExpedicao(dataExpedicao);
        this.encomendas.add(e.numeroProdutos(),e.clone());
    }

    public List<Utilizador> getListUtilizadores() throws ObjectEmpty {
        List<Utilizador> utilizadores = this.utilizador.values().stream().map(Utilizador::clone).collect(Collectors.toList());
        if (utilizadores.isEmpty()) {
            throw new ObjectEmpty("Não existem Utilizadores!");
        } else {
            return utilizadores;
        }
    }

    public List<Transportadora> getListTransportadoras() throws ObjectEmpty {
        List<Transportadora> transportadoras = this.transportadora.values().stream().map(Transportadora::clone).collect(Collectors.toList());
        if (transportadoras.isEmpty()) {
            throw new ObjectEmpty("Não existem Transportadoras!");
        } else {
            return transportadoras;
        }
    }

    public List<Produto> getListProdutos() throws ObjectEmpty {
        List<Produto> listprodutos = this.produtos.values().stream().map(Produto::clone).collect(Collectors.toList());
        if (listprodutos.isEmpty()) {
            throw new ObjectEmpty("Não existem Produtos!");
        } else {
            return listprodutos;
        }
    }
    /*
    public List<Produto> getProdutosUtilizador (String u) throws ObjectNullException {
        if (this.utilizador.containsKey(u)) {
            List<Produto> list = new ArrayList<>();

            for (Produto produto : produtos) {
                if (u.equals(produto.getCodigo())) {
                    list.add(produto.clone());
                }
            }
            return list;
        } else {
            throw new ObjectNullException("Utlizador não existe!");
        }
    } */

    public List<Produto> getProdutosUtilizador(String vendedor) {
        List<Produto> produtos = new ArrayList<>();
        for (Encomenda encomenda : getEncomenda()) {
            if (encomenda.getNomeVendedor().equals(vendedor)) {
                produtos.addAll(encomenda.getProdutos());
            }
        }

        return produtos;
    }

    public List<Fatura> gerarFaturas(List<Encomenda> encomendas) {
        List<Fatura> faturas = new ArrayList<>();

        // Mapa para agrupar as encomendas por vendedor e comprador
        Map<String, Map<String, List<Encomenda>>> encomendasPorVendedorComprador = encomendas.stream()
                .collect(Collectors.groupingBy(Encomenda::getNomeVendedor,
                        Collectors.groupingBy(Encomenda::getNomeComprador)));

        // Iterar sobre as encomendas agrupadas por vendedor e comprador
        for (Map.Entry<String, Map<String, List<Encomenda>>> vendedor : encomendasPorVendedorComprador.entrySet()) {
            String nomeVendedor = vendedor.getKey();
            Map<String, List<Encomenda>> encomendasPorComprador = vendedor.getValue();

            for (Map.Entry<String, List<Encomenda>> comprador : encomendasPorComprador.entrySet()) {
                String nomeComprador = comprador.getKey();
                List<Encomenda> encomendasDoComprador = comprador.getValue();

                // Cria uma fatura para as encomendas do comprador
                Fatura fatura = new Fatura();
                double total = 0;

                for (Encomenda enc : encomendasDoComprador) {
                    total += enc.calculaPrecoFinal();
                }

                DecimalFormat format = new DecimalFormat("0.00");

                fatura.setNomeVendedor(nomeVendedor);
                fatura.setNomeComprador(nomeComprador);
                fatura.setPrecoTotal(total);

                // Adiciona a fatura à lista de faturas
                faturas.add(fatura);
            }
        }

        return faturas;
    }

    public void makeAllFaturas (long dias) {
        for (int i=0; i<dias; i++) {
            List<Fatura> f = gerarFaturas(encomendas);
            f.toString();
        }
    }

    public String maiorVendedor(List<Fatura> faturas) {
        Map<String,Double> totalFaturadoPorVendedor = new HashMap<>();

        // Calcular o total faturado por cada vendedor
        for (Fatura fatura : faturas) {
            String nomeVendedor = fatura.getNomeVendedor();
            Double totalFaturado = totalFaturadoPorVendedor.getOrDefault(nomeVendedor, 0.0);
            totalFaturado += fatura.getPrecoTotal();
            totalFaturadoPorVendedor.put(nomeVendedor, totalFaturado);
        }

        // Procurar o vendedor com maior faturação
        String vendedorMaisFaturou = "";
        double maiorFaturamento = 0.0;

        for (Map.Entry<String, Double> entry : totalFaturadoPorVendedor.entrySet()) {
            String nomeVendedor = entry.getKey();
            Double totalFaturado = entry.getValue();
            if (totalFaturado > maiorFaturamento) {
                vendedorMaisFaturou = nomeVendedor;
                maiorFaturamento = totalFaturado;
            }
        }
        return vendedorMaisFaturou;
    }

    public void guardaEstado() throws FileNotFoundException, IOException, FileNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("database"));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }


    public static List<Produto> stringToListProdutos(String produtos) {
        List<Produto> listaProdutos = new ArrayList<>();
        String[] produtosArray = produtos.split(",");
        for (String produto : produtosArray) {
            listaProdutos.add(new Produto()); // aqui você deve criar o objeto Produto com o ID aleatório atribuído
        }
        return listaProdutos;
    }

    public void carregaEstado () throws IOException, ClassNotFoundException {
        Sys sys = carregaEstadoAux();
        this.produtos = sys.getProdutos();
        this.transportadora = sys.getTransportadora();
        this.utilizador = sys.getUtilizador();
        this.encomendas = sys.getEncomenda();
        this.id = sys.getId();
    }

    public Sys carregaEstadoAux () throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("database"));
        Sys sys = (Sys) ois.readObject();
        ois.close();
        return sys;
    }

    public String transportadoraMaisFaturou () {
        Map<String, Double> faturacaoTransportadoras = new HashMap<>();

        // Calcula o faturamento de cada transportadora
        for (Encomenda encomenda : encomendas) {
            String transportadora = encomenda.getNomeTransportadora();
            double valorTotal = encomenda.calculaPrecoFinal();
            faturacaoTransportadoras.put(transportadora, faturacaoTransportadoras.getOrDefault(transportadora, 0.0) + valorTotal);
        }

        String transportadoraMaisFaturou = null;
        double valorMaisFaturou = 0.0;

        // Percorre o mapa e encontra a transportadora que mais faturou
        for (Map.Entry<String, Double> entry : faturacaoTransportadoras.entrySet())
            if (entry.getValue() > valorMaisFaturou) {
                transportadoraMaisFaturou = entry.getKey();
                valorMaisFaturou = entry.getValue();
            }

        return transportadoraMaisFaturou;
    }

    public List<Encomenda> listarEncomendasVendedor(String vendedor) {
        List<Encomenda> encomendasVendedor = new ArrayList<>();
        for (Encomenda encomenda : encomendas) {
            if (encomenda.getNomeVendedor().equals(vendedor) || encomenda.getNomeVendedor().equals(vendedor)) {
                encomendasVendedor.add(encomenda);
            }
        }

        return encomendasVendedor;
    }

}
