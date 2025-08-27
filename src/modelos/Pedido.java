package modelos;

import java.time.LocalDateTime;

public class Pedido {
    public int id;
    public int idItem;
    public int idCliente;
    public String status;
    public LocalDateTime tempo;

    public Pedido(int id, int idItem, int idCliente) {
        this.id = id;
        this.idItem = idItem;
        this.idCliente = idCliente;
        this.status = "Aceito";
        this.tempo = LocalDateTime.now();
    }

    public void avancarStatus() {
        switch (status) {
            case "Aceito" -> status = "Preparando";
            case "Preparando" -> status = "Feito";
            case "Feito" -> status = "Aguardando entregador";
            case "Aguardando entregador" -> status = "Saiu para entrega";
            case "Saiu para entrega" -> status = "Entregue";
            default -> System.out.println("Pedido já finalizado.");
        }
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + " | Cliente ID: " + idCliente + " | Item ID: " + idItem + " | Status: " + status;
    }
}
