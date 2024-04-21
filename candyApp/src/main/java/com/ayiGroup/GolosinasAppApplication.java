package main.java.com.ayiGroup;

import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;
import main.java.com.ayiGroup.GolosinasApp.model.Usuario;
import main.java.com.ayiGroup.GolosinasApp.service.PedidoService;
import main.java.com.ayiGroup.GolosinasApp.service.UsuarioService;

public class GolosinasAppApplication {

    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        PedidoService pedidoService = new PedidoService(usuarioService);

        Usuario usuario = usuarioService.obtenerUsuarioPorId(1);
        System.out.println("Usuario obtenido: " + usuario.getNombre());

        System.out.println("Creando pedido...");
        var pedido = pedidoService.crearPedido(123, usuario);

        System.out.println("Cambiando estado del pedido a PENDIENTE_APROBACION...");
        boolean cambioExitoso = pedidoService.cambiarEstadoPedido(pedido.getId(), EstadoPedido.PENDIENTE_APROBACION);

        if (cambioExitoso) {
            System.out.println("Pedido " + pedido.getId() + " está ahora en estado " + pedido.getEstado().name());
        } else {
            System.out.println("No se pudo cambiar el estado del pedido " + pedido.getId());
        }

        
    }
}
