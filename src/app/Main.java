package app;

import java.util.Scanner;
import dados.BancoDeDados;
import servicos.ClienteService;
import servicos.ItemService;
import servicos.PedidoService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BancoDeDados.inicializarMock();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Listar Clientes");
            System.out.println("2 - Listar Itens");
            System.out.println("3 - Criar Pedido");
            System.out.println("4 - Avançar Status do Pedido");
            System.out.println("5 - Listar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> ClienteService.listarClientes();
                case 2 -> ItemService.listarItens();
                case 3 -> PedidoService.criarPedido(sc);
                case 4 -> PedidoService.avancarPedido(sc);
                case 5 -> PedidoService.listarPedidos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
