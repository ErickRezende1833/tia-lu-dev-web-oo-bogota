package servicos; 

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dados.BancoDeDados;
import modelos.Item;
import modelos.Pedido;

public class PedidoService { 
	public static void criarPedido(Scanner sc) { 
		System.out.print("Digite o ID do cliente: "); 
	int idCliente = sc.nextInt(); 


		List<Integer> idItens = new ArrayList<>();
		boolean adicionarItens = true;

		while (adicionarItens){
			System.out.print("Digite o ID do item: ");
			int iditem = sc.nextInt();
			idItens.add(iditem);
			System.out.print("(1) Adicionar mais itens: ");
			System.out.print("(0) Não adicionar mais itens: ");
			int resposta = sc.nextInt();
			if (resposta == 0){
				adicionarItens = false;
			}
		}

	int idPedido = BancoDeDados.pedidos.size() + 1;
	LocalDateTime tempo = LocalDateTime.now();
	Pedido novoPedido = new Pedido(idPedido, idItens, idCliente, tempo);
	BancoDeDados.pedidos.add(novoPedido);
	System.out.println("Pedido criado com sucesso!");
	}


	public static void gerarRelatorioSimplificado() {
		int totalPedidos = BancoDeDados.pedidos.size();
		double valorTotal = 0.0;

		for(Pedido pedido : BancoDeDados.pedidos){
			for(Integer idItem : pedido.idItens){
				for(Item item : BancoDeDados.itens){
					if(item.id == idItem){
						valorTotal += item.preco;
						break;
					}
				}
			}
		}

		System.out.println(totalPedidos);
		System.out.println(valorTotal);
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