package servicos; 

import java.time.LocalDateTime;
import java.util.Scanner;
import dados.BancoDeDados;
import modelos.Pedido; 

public class PedidoService { 
	public static void criarPedido(Scanner sc) { 
		System.out.print("Digite o ID do cliente: "); 
	int idCliente = sc.nextInt(); 
		System.out.print("Digite o ID do item: "); 
	int idItem = sc.nextInt(); 
	int idPedido = BancoDeDados.pedidos.size() + 1;
	LocalDateTime tempo = LocalDateTime.now();
	Pedido novoPedido = new Pedido(idPedido, idItem, idCliente, tempo);
	BancoDeDados.pedidos.add(novoPedido);
	System.out.println("Pedido criado com sucesso!");
	}

public static void listarPedidos() { 
	System.out.println("\n--- PEDIDOS ---"); 
	
	for (Pedido p : BancoDeDados.pedidos) { 
		System.out.println(p); 
		} 
	}

public static void avancarPedido(Scanner sc) { 
		System.out.print("Digite o ID do pedido: "); 
	int id = sc.nextInt(); 
	
	for (Pedido p : BancoDeDados.pedidos) { 
		if (p.id == id) { p.avancarStatus(); 
			System.out.println("Novo status: " + p.status);
				return; 
			} 
		}
	System.out.println("Pedido não encontrado."); 
	}
}