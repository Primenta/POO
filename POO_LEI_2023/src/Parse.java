import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Parse {

    public static void parsing (int next, Sys s) throws IOException, ObjectNullException, ClassNotFoundException {

        if (next == 1) {
            try (Scanner scanner = new Scanner(new File("ficheiro.txt"))) {
                scanner.useDelimiter("\n:");

                while (scanner.hasNext()) {
                    String token = scanner.next();

                    String[] parts = token.split("\n");

                    for (int i=0; i < parts.length; i++) {

                        String[] type = parts[i].split(":");
                        String[] argsSplited = type[1].split(",");
                        List<Produto> produtos;

                        switch (type[0]) {
                            case "Transportadora":
                                Transportadora t = new Transportadora(argsSplited[0], Double.parseDouble(argsSplited[1]), Double.parseDouble(argsSplited[2]), Double.parseDouble(argsSplited[3]), Double.parseDouble(argsSplited[4]), Double.parseDouble(argsSplited[5]), Boolean.parseBoolean(argsSplited[6]));
                                s.addTransportadora(t.getNome(), t.clone());
                                break;
                            case "Utilizador":
                                Utilizador u = new Utilizador(argsSplited[0], argsSplited[1], argsSplited[2], argsSplited[3], argsSplited[4]);
                                s.addUtilizador(u.getNome(), u.clone());
                                break;
                            case "Encomenda":
                                produtos = stringToListProdutos(argsSplited[0]);
                                Encomenda e = new Encomenda(produtos, argsSplited[1], argsSplited[2], argsSplited[3], Enum.valueOf(Encomenda.Embalagem.class, argsSplited[4]), Enum.valueOf(Encomenda.EstadoEncomenda.class, argsSplited[5]), Double.parseDouble(argsSplited[6]), Double.parseDouble(argsSplited[7]), Double.parseDouble(argsSplited[8]), argsSplited[9], argsSplited[10]);
                                s.addEncomenda(e);
                                break;
                            case "Produto":
                                if (Objects.equals(argsSplited[0], "Sapatilha")) {
                                    Sapatilha sp = new Sapatilha(argsSplited[1], argsSplited[2], argsSplited[3], Enum.valueOf(Produto.Estado.class, argsSplited[4]), Double.parseDouble(argsSplited[5]), Double.parseDouble(argsSplited[6]), argsSplited[7], Integer.parseInt(argsSplited[8]), Boolean.parseBoolean(argsSplited[9]), argsSplited[10], Integer.parseInt(argsSplited[11]), Boolean.parseBoolean(argsSplited[12]), Boolean.parseBoolean(argsSplited[13]), Integer.parseInt(argsSplited[14]), Double.parseDouble(argsSplited[15]));
                                    s.addProduto(sp.getProprietario(), sp.clone());
                                }
                                if (Objects.equals(argsSplited[0], "Mala")) {
                                    Mala m = new Mala(argsSplited[1], argsSplited[2], argsSplited[3], Enum.valueOf(Produto.Estado.class, argsSplited[4]), Double.parseDouble(argsSplited[5]), Double.parseDouble((argsSplited[6])), argsSplited[7], Double.parseDouble(argsSplited[8]), argsSplited[9], Integer.parseInt(argsSplited[10]), Boolean.parseBoolean(argsSplited[11]));
                                    s.addProduto(m.getProprietario(), m.clone());
                                }
                                if (Objects.equals(argsSplited[0], "T-Shirt")) {
                                    TShirt ts = new TShirt(argsSplited[1], argsSplited[2], argsSplited[3], Enum.valueOf(Produto.Estado.class, argsSplited[4]), Double.parseDouble(argsSplited[5]), Double.parseDouble(argsSplited[6]), argsSplited[7], argsSplited[8], TShirt.Padrao.valueOf(argsSplited[9]));
                                    s.addProduto(ts.getProprietario(), ts.clone());
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        } else {
            // Carregar de binário
            s.carregaEstado();
            Menu.Mensagem(2);
        }
    }



    public static List<Produto> stringToListProdutos(String produtos) {
        List<Produto> listaProdutos = new ArrayList<>();
        String[] produtosArray = produtos.split("-");
        for (String produto : produtosArray) {
            listaProdutos.add(new Produto(produto)); // aqui você deve criar o objeto Produto com o ID aleatório atribuído
        }
        return listaProdutos;
    }
}
