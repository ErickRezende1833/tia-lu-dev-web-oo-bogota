package servicos; 

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dados.BancoDeDados;
import modelos.Cliente;
import modelos.Item;
import modelos.Pedido;

public class PedidoService { 
	public static void criarPedido(Scanner sc) {

		ClienteService.listarClientes();
		System.out.print("\nDigite o ID do cliente: ");
		int idCliente = sc.nextInt();
		boolean adicionarItens = true;

		List<Integer> idItens = new ArrayList<>();
		ItemService.listarItens();

		while (adicionarItens){
			System.out.print("\nDigite o ID do item: ");
			int iditem = sc.nextInt();
			System.out.print("Quantidade: ");
			int qtd = sc.nextInt();

			for(int i = 0; i < qtd; i++ ){
				idItens.add(iditem);
			}

			System.out.println("(1) Adicionar mais itens: ");
			System.out.println("(0) Não adicionar mais itens: ");
			System.out.print("Escolha: ");
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
		LocalDate dataHoje = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataHojef = dataHoje.format(formatter);

		System.out.println("\n=== Relatório Simples "+ dataHojef + " ===");
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

		System.out.println("Total de pedidos: " + totalPedidos);
		System.out.println("Valor total dos pedidos: " + String.format("%.2f", valorTotal));
	}

	public static void gerarRelatorioDetalhado() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("\n=== Relatório Detalhado ===");

		for (Pedido pedido : BancoDeDados.pedidos) {
			double totalPedido = 0.0;

			System.out.println("\nPedido ID: " + pedido.id);
			System.out.println("Data: " + pedido.tempo.format(formatter));

			for (Cliente cliente : BancoDeDados.clientes) {
				if (cliente.id == pedido.idCliente) {
					System.out.println("Cliente ID: " + cliente.id + " | Nome: " + cliente.nome + " | Telefone: " + cliente.telefone);
					break;
				}
			}
			System.out.println("Itens:");

			for (Item item : BancoDeDados.itens) {
				int quantidade = 0;

				for (Integer idItem : pedido.idItens) {
					if (idItem == item.id) {
						quantidade++;
					}
				}

				if (quantidade > 0) {
					double subtotal = item.preco * quantidade;
					System.out.println( item.nome + " " + quantidade + "x | R$ " + String.format("%.2f", subtotal));
					totalPedido += subtotal;
				}
			}

			System.out.println("Total do pedido: R$ " + String.format("%.2f", totalPedido));
		}
	}

	public static void buscarPedidoPorStatus(Scanner sc){
		System.out.println("Escolha o status buscado:");
		System.out.println("1 - Aceito");
		System.out.println("2 - Preparando");
		System.out.println("3 - Feito");
		System.out.println("4 - Aguardando entregador");
		System.out.println("5 - Saiu para entrega");
		System.out.println("6 - Entregue");
		System.out.print("Escolha: ");

		String statusBuscado = "";

		int opcao = sc.nextInt();

		switch (opcao){
			case 1 -> statusBuscado = "Aceito";
			case 2 -> statusBuscado = "Preparando";
			case 3 -> statusBuscado = "Feito";
			case 4 -> statusBuscado = "Aguardando entregador";
			case 5 -> statusBuscado = "Saiu para entrega";
			case 6 -> statusBuscado = "Entregue";
			default -> System.out.println("Pedido já finalizado.");
		}

		System.out.println("\n--- PEDIDOS ---");

		boolean isEncontrado = false;
		for (Pedido pedido : BancoDeDados.pedidos){
			if(statusBuscado.equals(pedido.status)){
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				String tempof = pedido.tempo.format(formatter);
				System.out.println("Pedido ID: " + pedido.id + " | Cliente ID: " + pedido.idCliente + " | Item ID: " + pedido.idItens + " | Data e hora: " + tempof + " | Status: " + pedido.status);
				isEncontrado = true;
			}
		}

		if(!isEncontrado){
			System.out.println("Nenhum pedido encontrado com o status " + statusBuscado + ".");
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