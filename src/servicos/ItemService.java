package servicos;

import dados.BancoDeDados;
import modelos.Item;

import java.util.Scanner;

public class ItemService {
    
//    public static void cadastrarItem(String nome, String tipo, double preco) {
//        int id = BancoDeDados.gerarIdItem();
//        Item novoItem = new Item(id, nome, tipo, preco);
//
//        BancoDeDados.itens.add(novoItem);
//        System.out.println("Item cadastrado com sucesso! ID: " + id);
//    }

    public static void cadastrarItem(Scanner sc){
        System.out.print("Digite o nome do item: ");
        String nome = sc.nextLine();
        System.out.print("Digite o tipo do item: ");
        String tipo = sc.nextLine();
        System.out.print("Digite o preço do item: ");
        Double preco = sc.nextDouble();
        int id = BancoDeDados.gerarIdItem();
        Item novoItem = new Item(id, nome, tipo, preco);
        BancoDeDados.itens.add(novoItem);
        System.out.println("Item cadastrado com sucesso! ID: " + id);


    }
    
    public static void listarItens() {
        System.out.println("\n--- ITENS ---");
        
        for (Item i : BancoDeDados.itens) {
            System.out.println(i);
        }
    }
}
