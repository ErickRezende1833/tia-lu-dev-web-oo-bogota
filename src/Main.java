import java.awt.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            int opcao = mostrarMenu(scanner);

            switch (opcao){
                case 1:
                    System.out.println("Menu Clientes selecionado");
                    break;
                case 2:
                    System.out.println("Menu Cardápio selecionado");
                    break;
                case 3:
                    System.out.println("Menu pedidos selecionado");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;

            }
        break;

        }
    }

    public static int mostrarMenu(Scanner scanner){

        System.out.println("Menu");
        System.out.println("1 = Menu Clientes");
        System.out.println("2 = Menu Cardápio");
        System.out.println("3 = Menu Pedidos");

        return scanner.nextInt();
    }


}