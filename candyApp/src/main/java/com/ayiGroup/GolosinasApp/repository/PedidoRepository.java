package main.java.com.ayiGroup.GolosinasApp.repository;

import main.java.com.ayiGroup.GolosinasApp.model.Pedido;
import java.util.HashMap;
import java.util.Map;

public class PedidoRepository {
    private Map<Integer, Pedido> pedidos = new HashMap<>();

    public Pedido find(int id) {
        return pedidos.get(id);
    }

    public void save(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }
}