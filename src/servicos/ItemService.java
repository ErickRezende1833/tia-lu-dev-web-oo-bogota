package servicos;

import dados.BancoDeDados;

public class ItemService {
	
    
    public static void cadastrarItem(String nome, String tipo, double preco) {
        int id = BancoDeDados.gerarIdItem();
    }
}   