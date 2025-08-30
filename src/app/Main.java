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
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Listar Itens");
            System.out.println("4 - Cadastrar Item");
            System.out.println("5 - Criar Pedido");
            System.out.println("6 - Avançar Status do Pedido");
            System.out.println("7 - Listar Pedidos por Status");
            System.out.println("8 - Gerar relatorio simplificado");
            System.out.println("9 - Gerar relatório Detalhado");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try{
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> ClienteService.listarClientes();
                case 2 -> ClienteService.cadastrarCliente(sc);
                case 3 -> ItemService.listarItens();
                case 4 -> ItemService.cadastrarItem(sc);
                case 5 -> PedidoService.criarPedido(sc);
                case 6 -> PedidoService.avancarPedido(sc);
                case 7 -> PedidoService.buscarPedidoPorStatus(sc);
                case 8 -> PedidoService.gerarRelatorioSimplificado();
                case 9 -> PedidoService.gerarRelatorioDetalhado();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

            } catch (Exception e){
                    System.out.println("Erro: entrada inválida. Digite um número.");
                    sc.nextLine();
                    opcao = -1;
                }

        } while (opcao != 0);

        sc.close();
    }
}
