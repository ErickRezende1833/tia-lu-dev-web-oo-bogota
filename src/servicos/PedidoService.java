package servicos; 

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
	Pedido novoPedido = new Pedido(idPedido, idItem, idCliente);
	BancoDeDados.pedidos.add(novoPedido);
		System.out.println("Pedido criado com sucesso!");
		} 
}