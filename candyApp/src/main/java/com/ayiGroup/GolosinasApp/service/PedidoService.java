package main.java.com.ayiGroup.GolosinasApp.service;

import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;
import main.java.com.ayiGroup.GolosinasApp.model.Pedido;
import main.java.com.ayiGroup.GolosinasApp.model.Usuario;
import main.java.com.ayiGroup.GolosinasApp.repository.PedidoRepository;

public class PedidoService {

    private static int ultimoId = 0; 
    private PedidoRepository pedidoRepository;
    private UsuarioService usuarioService;

    public PedidoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.pedidoRepository = new PedidoRepository();
    }

    public Pedido crearPedido(Usuario solicitante) {
        ultimoId++; 
        Pedido nuevoPedido = new Pedido(ultimoId, solicitante);
        pedidoRepository.save(nuevoPedido);
        return nuevoPedido;
    }

    public boolean cambiarEstadoPedido(int pedidoId, EstadoPedido nuevoEstado) {
        Pedido pedido = pedidoRepository.find(pedidoId);
        if (pedido != null) {
            pedido.setEstado(nuevoEstado);
            pedidoRepository.save(pedido);
            return true;
        }
        return false;
    }

    public Pedido obtenerPedidoPorId(int pedidoId) {
        return pedidoRepository.find(pedidoId);
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
}
