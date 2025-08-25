package servicos;

import dados.BancoDeDados;
import modelos.Item;

public class ItemService {
    
    public static void cadastrarItem(String nome, String tipo, double preco) {
        int id = BancoDeDados.gerarIdItem();
        Item novoItem = new Item(id, nome, tipo, preco);
    }
}   
