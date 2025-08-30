package modelos;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    public int id;
    public List<Integer> idItens;
    public int idCliente;
    public String status;
    public LocalDateTime tempo;

    public Pedido(int id, List<Integer> idItens, int idCliente, LocalDateTime tempo) {
        this.id = id;
        this.idItens = idItens;
        this.idCliente = idCliente;
        this.status = "Aceito";
        this.tempo = tempo;
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
}
