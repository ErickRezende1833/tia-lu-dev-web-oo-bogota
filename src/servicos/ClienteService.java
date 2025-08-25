package servicos;

import dados.BancoDeDados;
import modelos.Cliente;

public class ClienteService {
    
    public static void cadastrarCliente(String nome, String telefone) {
        int id = BancoDeDados.gerarIdCliente();
        Cliente novoCliente = new Cliente(id, nome, telefone);

        BancoDeDados.clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso! ID: " + id);
    }
    
    public static void listarClientes() {
    }
}