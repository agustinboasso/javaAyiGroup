package main.java.com.ayiGroup.GolosinasApp.service;

import main.java.com.ayiGroup.GolosinasApp.model.Pedido;
import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;
import main.java.com.ayiGroup.GolosinasApp.model.Usuario;
import main.java.com.ayiGroup.GolosinasApp.repository.PedidoRepository;
import main.java.com.ayiGroup.GolosinasApp.utils.EstadoPedidoChecker;

public class PedidoService {

    private PedidoRepository pedidoRepository;
    private UsuarioService usuarioService;

    public PedidoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        this.pedidoRepository = new PedidoRepository();
    }

    public Pedido crearPedido(int id, Usuario solicitante) {
        Pedido nuevoPedido = new Pedido(id, solicitante);
        pedidoRepository.save(nuevoPedido);
        return nuevoPedido;
    }

    public boolean cambiarEstadoPedido(int pedidoId, EstadoPedido nuevoEstado) {
        Pedido pedido = pedidoRepository.find(pedidoId);
        if (pedido != null && EstadoPedidoChecker.puedeCambiar(pedido.getEstado(), nuevoEstado)) {
            pedido.setEstado(nuevoEstado);
            pedidoRepository.save(pedido); 
            return true;
        }
        return false;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
}
