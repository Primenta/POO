import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import static java.time.LocalDate.now;

public class Menu {
    public static int MenuInicial() throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append("##############################################\n");
        sb.append("#                                            #\n");
        sb.append("# ---------------- VINTAGE ----------------- #\n");
        sb.append("# (1) Carregar ficheiro                      #\n");
        sb.append("# (2) Salvar ficheiro                        #\n");
        sb.append("# (3) Verificar Utilizadores existentes      #\n");
        sb.append("# (4) Verificar Transportadoras              #\n");
        sb.append("# (5) Verificar Lista de Produtos            #\n");
        sb.append("# (6) Verificar Produtos á Venda             #\n");
        sb.append("# (7) Adicionar um Utilizador                #\n");
        sb.append("# (8) Adicionar um Produto                   #\n");
        sb.append("# (9) Adicionar uma Transportadora           #\n");
        sb.append("# (10) Fazer uma Encomenda                    #\n");
        sb.append("# (11) Vendedor que mais faturou             #\n");
        sb.append("# (12) Transportadora que mais faturou       #\n");
        sb.append("# (13) Encomendas de um vendedor             #\n");
        sb.append("# (14) Lista maiores compradores             #\n");
        sb.append("# (15) Lista maiores vendedores              #\n");
        sb.append("# (16) Simulação (Avançar no Tempo)          #\n");
        sb.append("# (17) Faturação da VINTAGE                  #\n");
        sb.append("#                                            #\n");
        sb.append("# (0) Sair                                   #\n");
        sb.append("#                                            #\n");
        sb.append("##############################################\n\n");

        sb.append("Seleciona uma das opções acima:");
        System.out.println(sb);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void Carregamento() {
        StringBuilder sb = new StringBuilder();
        sb.append("A carregar Dados do Ficheiro...\n");
        System.out.println(sb);
    }

    public static void MenuSimulacao() {
        StringBuilder sb = new StringBuilder("------------- MENU SIMULAÇÃO ------------\n");
    }

    public static void voltar() {
        System.out.println("\n(0) Voltar");
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
    }

    // Recebe uma lista de Utilizadores
    public static void MenuShowUtilizadores (List<Utilizador> utilizadores) {
        StringBuilder sb = new StringBuilder("------------- UTILIZADORES ------------\n");
        for (Utilizador utilizador : utilizadores) {
            sb.append(utilizador.toString());
        }
        System.out.println(sb);
    }

    // Recebe uma lista de Transportadores
    public static void MenuShowTransportadoras (List<Transportadora> transportadoras) {
        StringBuilder sb = new StringBuilder("----------- TRANSPORTADORAS ---------------\n");
        for (Transportadora transportadora : transportadoras) {
            sb.append(transportadora.toString());
        }
        System.out.println(sb);
    }

    // Recebe uma lista de Produtos
    public static void MenuShowProdutos (List<Produto> produtos) {
        StringBuilder sb = new StringBuilder("------------ PRODUTOS --------------\n");
        for (Produto produto : produtos) {
            sb.append(produto.toString());
        }
        System.out.println(sb);
    }

    // Mostra os produtos que umm Utilizador tem à venda
    public static void MenuShowProdutosaVenda (String utilizador, List<Produto> produtos) {
        StringBuilder sb = new StringBuilder("------------------ PRODUTOS À VENDA --------------\n");
        sb.append("[Utilizador]: ").append(utilizador);
        if (produtos.isEmpty()) {
            System.out.println("Este Utilizador não existe ou nao tem produtos à venda\n(0) Voltar");
        } else {
            for (Produto produto : produtos) {
                sb.append(produto.toString());
            }
        }
        System.out.println(sb);
    }

    public static String MenuShowUtlizadorProdutos () {
        StringBuilder sb = new StringBuilder("Indique qual o Utilizador: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    // Adicionar um Utilizador
    public static String[] MenuNovoUtilizador() {
        StringBuilder sb = new StringBuilder("Insira o id do Utilizador que pretende adicionar");
        System.out.println(sb.toString());
        String[] args = new String[] {"","","","",""};
        Scanner scanner = new Scanner(System.in);
        args[0] = scanner.nextLine();
        System.out.println("Insira a Email do Utilizador que pretende adicionar!");
        args[1] = scanner.nextLine();
        System.out.println("Insira a Nome do Utilizador que pretende adicionar!");
        args[2] = scanner.nextLine();
        System.out.println("Insira a Morada do Utilizador que pretende adicionar!");
        args[3] = scanner.nextLine();
        System.out.println("Insira o Número Fiscal do Utilizador que pretende adicionar!");
        args[4] = scanner.nextLine();
        return args;
    }

    // Adicionar um Produto
    public static String[] MenuNovoProduto() {
        StringBuilder sb = new StringBuilder("Insira a descrição do Produto que pretende adicionar\n");
        System.out.println(sb.toString());
        String[] args = new String[] {"","","","","","",""};
        Scanner scanner = new Scanner(System.in);
        args[0] = scanner.nextLine();
        System.out.println("Insira a Marca do Produto");
        args[1] = scanner.nextLine();
        System.out.println("Insira o Codigo do Produto");
        args[2] = scanner.nextLine();
        System.out.println("Insira o Estado do Produto");
        args[3] = scanner.nextLine();
        System.out.println("Insira o Preço Base do Produto");
        args[4] = scanner.nextLine();
        System.out.println("Insira a Correção de Preço do Produto");
        args[6] = scanner.nextLine();
        System.out.println("Insira um dos Proprietários existentes");
        args[5] = scanner.nextLine();
        return args;
    }

    // Adicionar uma Transportadora
    public static String[] MenuNovaTransportadora() {
        StringBuilder sb = new StringBuilder("Insira o nome da Transportadora que pretende adicionar\n");
        System.out.println(sb.toString());
        String[] args = new String[] {"","","","","",""};
        Scanner scanner = new Scanner(System.in);
        args[0] = scanner.nextLine();
        System.out.println("Insira o fator de Imposto");
        args[1] = scanner.nextLine();
        System.out.println("Insira a margem de lucro da Transportadora");
        args[2] = scanner.nextLine();
        System.out.println("Diga se a Transportadoa é especializada em Premium");
        args[3] = scanner.nextLine();
        return args;
    }

    public static long Simulacao() {
        LocalDate today = now();
        System.out.println("Data de hoje: ");
        String dataFormatada = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        System.out.println(dataFormatada);
        System.out.println("Insira uma data: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(date, formatter);
        long timePassed = ChronoUnit.DAYS.between(today, localDate);
        System.out.println("Dias a simular: ");
        System.out.println(timePassed);
        return timePassed;
    }

    public static void MenuMaiorVendedor(String maiorVendedor) {
        StringBuilder sb = new StringBuilder("O Vendedor que mais faturou foi: ");
        System.out.println(sb);
        System.out.println(maiorVendedor);
    }

    public static void MenuTransportadoraMaisFaturou(String maiorTransportadora) {
        StringBuilder sb = new StringBuilder("A Transportadora que mais faturou foi: ");
        System.out.println(sb);
        System.out.println(maiorTransportadora);
    }

    public static String MenuEncomendasVendedor() {
        StringBuilder sb = new StringBuilder("Introduza o vendedor que pretende ver: ");
        System.out.println(sb);
        Scanner scanner = new Scanner(System.in);
        String vendedor = scanner.nextLine();
        return vendedor;
    }

    public static String[] MenuNovaEncomenda() {
        StringBuilder sb = new StringBuilder("Insira a Lista de Produtos da Encomenda");
        System.out.println(sb.toString());
        String[] args = new String[] {"","","","",""};
        Scanner scanner = new Scanner(System.in);
        args[0] = scanner.nextLine();
        System.out.println("Insira o nome do Vendedor");
        args[1] = scanner.nextLine();
        System.out.println("Insira o nome do Comprador");
        args[2] = scanner.nextLine();
        System.out.println("Insira o nome da Transportadora");
        args[3] = scanner.nextLine();
        System.out.println("Insira o tamanho da Embalagem");
        args[4] = scanner.nextLine();
        System.out.println("Insira o estado da Encomenda");
        args[5] = scanner.nextLine();
        System.out.println("Insira a taxa de Novo");
        args[6] = scanner.nextLine();
        System.out.println("Insira a taxa de Usado");
        args[7] = scanner.nextLine();
        System.out.println("Insira o Custo de Expedição");
        args[8] = scanner.nextLine();
        System.out.println("Insira a Data de Criação");
        args[9] = scanner.nextLine();
        System.out.println("Insira a Data de Expediçao");
        args[10] = scanner.nextLine();
        return args;
    }


    // Mensagens

    public static void Mensagem(int mensagem) {
        switch (mensagem) {
            case 1:
                System.out.println("-- Obrigado, volte sempre ! --\n");
                break;
            case 2:
                System.out.println("-- Estado Carregado ! --\n");
                break;
            case 8:
                System.out.println("-- Estado Guardado ! --\n");
                break;
            case 3:
                System.out.println("-- Utilizador adicionado com sucesso! --\n");
                break;
            case 4:
                System.out.println("-- Produto adicionado com sucesso! --\n");
                break;
            case 5:
                System.out.println("-- Transportadora adicionada com sucesso --\n");
                break;
            case 6:
                System.out.println("-- Encomenda Concluída! --\n");
                break;
            case 7:
                System.out.println("-- Simulação Concluída! --\n");
                break;
            case 9:
                System.out.println("-- Transportadora adicionada com sucesso! --");
                break;
            case 10:
                System.out.println("-- Encomenda criada com sucesso! --");
                break;
            default:
                break;
        }
    }

    // Erros

    public static void erros(int erros) {
        switch (erros) {
            case 1:
                System.out.println("-- O Ficheiro não foi Carregado/Encontrado !--");
                break;
            case 2:
                System.out.println("-- Não existem Utilizadores! --\n");
                break;
            case 3:
                System.out.println("-- Não existem Produtos! --\n");
                break;
            case 4:
                System.out.println("-- Utilizador não encontrado! --\n");
                break;
            case 5:
                System.out.println("-- Não existem Transportadoras! --\n");
                break;
            case 6:
                System.out.println("-- O Produto não pode ser criado! --\n");
                break;
            default:
                break;
        }
    }


}
