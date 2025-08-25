package modelos;

public class Pedido {
    public int id;
    public int idItem;
    public int idCliente;
    public String status;

    public Pedido(int id, int idItem, int idCliente) {
        this.id = id;
        this.idItem = idItem;
        this.idCliente = idCliente;
        this.status = "Aceito";
    }
}
