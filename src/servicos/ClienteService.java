package servicos;

import dados.BancoDeDados;
import modelos.Cliente;

import java.util.Scanner;

public class ClienteService {

    public static void cadastrarCliente(Scanner sc){
        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("Digite o telefone do cliente: ");
        String telefone = sc.nextLine();
        int id = BancoDeDados.gerarIdCliente();
        Cliente novoCliente = new Cliente(id, nome, telefone);
        BancoDeDados.clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso! ID: " + id);
    }
    
    public static void listarClientes() {
        System.out.println("\n--- CLIENTES ---");
        
        for (Cliente c : BancoDeDados.clientes) {
           System.out.println("ID: " + c.id + " | Nome: " + c.nome + " | Telefone: " + c.telefone);
            }
    }
}
