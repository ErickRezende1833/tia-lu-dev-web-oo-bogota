package servicos; 

import java.util.Scanner; 
import dados.BancoDeDados; 

public class PedidoService { 
	public static void criarPedido(Scanner sc) { 
		System.out.print("Digite o ID do cliente: "); 
	int idCliente = sc.nextInt(); 
		System.out.print("Digite o ID do item: "); 
	int idItem = sc.nextInt(); 
	int idPedido = BancoDeDados.pedidos.size() + 1; 
		} 
}