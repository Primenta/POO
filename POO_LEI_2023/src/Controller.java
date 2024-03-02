import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static void run() throws IOException, ObjectNullException, ClassNotFoundException, ObjectEmpty {
        Sys s = new Sys();
        while (true) {
            int opcao = -1;
            while (opcao < 0 || opcao > 18) {

                opcao = Menu.MenuInicial();

            }
            switch (opcao) {
                case 0:
                    Menu.Mensagem(1);
                    System.exit(0);
                    break;
                case 1:
                    // Carregar o ficheiro
                    Menu.Carregamento();
                    Menu.Mensagem(2);
                    int next = 1;

                    try {
                       Parse.parsing(next,s);
                    } catch (FileNotFoundException e) {
                        Menu.erros(1);
                    }
                    break;
                case 2:
                    // Guardar Ficheiro
                    Menu.Mensagem(8);
                    break;
                case 3:
                    // Verificar utilizadores existentes
                    try {
                        List<Utilizador> list = s.getListUtilizadores();
                        Menu.MenuShowUtilizadores(list);
                        Menu.voltar();
                    } catch (ObjectEmpty e) {
                        Menu.erros(2);
                    }
                    break;
                case 4:
                    // Verificar transportadoras existentes
                    try {
                        List<Transportadora> list = s.getListTransportadoras();
                        Menu.MenuShowTransportadoras(list);
                        Menu.voltar();
                    } catch (ObjectEmpty e) {
                        Menu.erros(5);
                    }
                    break;
                case 5:
                    // Verificar Produtos existentes
                    try {
                        List<Produto> list = s.getListProdutos();
                        Menu.MenuShowProdutos(list);
                        Menu.voltar();
                    } catch (ObjectEmpty e) {
                        Menu.erros(3);
                    }
                    break;
                case 6:
                    // Verificar Produtos que um Utilizador tem à venda
                    String utilizador = Menu.MenuShowUtlizadorProdutos();
                    List<Produto> list = s.getProdutosUtilizador(utilizador);
                    Menu.MenuShowProdutosaVenda(utilizador,list);
                    Menu.voltar();
                    break;
                case 7:
                    // Adicionar um novo utilizador
                    String[] novoUtilizador = Menu.MenuNovoUtilizador();
                    s.novoUtilizador(novoUtilizador);
                    Menu.Mensagem(5);
                    break;
                case 8:
                    // Adicionar um novo produto
                    String[] novoProduto = Menu.MenuNovoProduto();
                    s.novoProduto(novoProduto);
                    Menu.Mensagem(4);
                    break;
                case 9:
                    // Adicionar uma Transportadora
                    String[] novaTransportadora = Menu.MenuNovaTransportadora();
                    s.novaTransportadora(novaTransportadora);
                    Menu.Mensagem(9);
                    break;
                case 10:
                    // Fazer uma Encomenda
                    String[] novaEncomenda = Menu.MenuNovaEncomenda();
                    List<Produto> produtos = new ArrayList<>();
                    SimpleDateFormat dataCriacao = new SimpleDateFormat();
                    SimpleDateFormat dataExpedicao = new SimpleDateFormat();
                    s.novaEncomenda(novaEncomenda, produtos, dataCriacao, dataExpedicao);
                    Menu.Mensagem(10);
                    break;
                case 11:
                    // Vendedor que mais faturou
                    List<Fatura> f = s.getFaturas();
                    String bestSeller = s.maiorVendedor(f);
                    Menu.MenuMaiorVendedor(bestSeller);
                    Menu.voltar();
                    break;
                case 12:
                    // Transportadora que mais faturou
                    Menu.MenuTransportadoraMaisFaturou(s.transportadoraMaisFaturou());
                    Menu.voltar();
                    break;
                case 13:
                    // Encomendas de um Vendedor
                    String vendedor = Menu.MenuEncomendasVendedor();
                    s.listarEncomendasVendedor(vendedor);
                    Menu.voltar();
                    break;
                case 14:
                    // Lista de maiores Compradores
                    break;
                case 15:
                    // Lista de maiores Vendedores
                    break;
                case 16:
                    // Avançar no tempo
                    Menu.MenuSimulacao();
                    long days = Menu.Simulacao();
                    s.makeAllFaturas(days);
                    Menu.Mensagem(7);
                    break;
                case 17:
                    // Faturação da Vintage
                    break;
            }
        }
    }
}
