package dados;

import java.util.ArrayList;
import modelos.Cliente;
import modelos.Item;
import modelos.Pedido;

public class BancoDeDados {
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Item> itens = new ArrayList<>();
    public static ArrayList<Pedido> pedidos = new ArrayList<>();
    

    private static int nextClienteId = 1;
    private static int nextItemId = 1;
    private static int nextPedidoId = 1;

    public static int gerarIdCliente() { return nextClienteId++; }
    public static int gerarIdItem() { return nextItemId++; }
    public static int gerarIdPedido() { return nextPedidoId++; }

    public static void inicializarMock() {
        clientes.add(new Cliente(gerarIdCliente(), "Erick Rezende", "99999-1111"));
        clientes.add(new Cliente(gerarIdCliente(), "Laysa Lima", "98888-2222"));
        clientes.add(new Cliente(gerarIdCliente(), "Vinicios Costa", "97777-3333"));

        itens.add(new Item(gerarIdItem(), "Bolo de chocolate", "Sobremesa", 35.90));
        itens.add(new Item(gerarIdItem(), "Hambúrguer", "Comida", 22.50));
        itens.add(new Item(gerarIdItem(), "Coca-Cola 2L", "Bebida", 10.00));
    }
}