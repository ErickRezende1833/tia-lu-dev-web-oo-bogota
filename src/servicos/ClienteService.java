package servicos;

import dados.BancoDeDados;

public class ClienteService {
    
    public static void cadastrarCliente(String nome, String telefone) {
        int id = BancoDeDados.gerarIdCliente();
    }
}
