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
    }