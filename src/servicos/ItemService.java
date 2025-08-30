package servicos;

import dados.BancoDeDados;
import modelos.Item;

import java.util.Objects;
import java.util.Scanner;

public class ItemService {

    public static void cadastrarItem(Scanner sc) {
        try {
            System.out.print("Digite o nome do item: ");
            String nome = sc.nextLine();
            if (Objects.equals(nome, "")){
                System.out.println("Erro: nome invalido ");
                cadastrarItem(sc);
            }
            System.out.print("Digite o tipo do item: ");
            String tipo = sc.nextLine();
            if (Objects.equals(nome, "")){
                System.out.println("Erro: nome invalido ");
                cadastrarItem(sc);
            }
            System.out.print("Digite o preço do item: ");
            double preco = sc.nextDouble();
            int id = BancoDeDados.gerarIdItem();
            Item novoItem = new Item(id, nome, tipo, preco);
            BancoDeDados.itens.add(novoItem);
            System.out.println("Item cadastrado com sucesso! ID: " + id);
        } catch (Exception e) {
            System.out.println("Erro: entrada inválida. O preço deve ser um número.");
            sc.nextLine();
        }
    }
    
    public static void listarItens() {
        System.out.println("\n--- ITENS ---");
        
        for (Item i : BancoDeDados.itens) {
            System.out.println("ID: " + i.id + " | Nome: " + i.nome + " | Tipo: " + i.tipo + " | Preço: R$ " + i.preco);
        }
    }
}
