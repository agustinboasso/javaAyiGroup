package main.java.com.ayiGroup;

import java.util.Scanner;
import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;
import main.java.com.ayiGroup.GolosinasApp.model.Usuario;
import main.java.com.ayiGroup.GolosinasApp.service.PedidoService;
import main.java.com.ayiGroup.GolosinasApp.service.UsuarioService;

public class GolosinasAppApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService();
        PedidoService pedidoService = new PedidoService(usuarioService);

        System.out.println("Por favor, introduzca su nombre:");
        String primerNombre = scanner.nextLine();
        
        Usuario primerUsuario = usuarioService.crearUsuario(primerNombre);
        System.out.println("Usuario creado: ID " + primerUsuario.getId() + ", Nombre: " + primerUsuario.getNombre());
        System.out.println(" ");
        System.out.println("¿El pedido es mayorista o minorista? (mayorista/minorista)");
        String tipoPedido = "";
        while (true) {
            tipoPedido = scanner.nextLine().trim().toLowerCase();
            if ("mayorista".equals(tipoPedido) || "minorista".equals(tipoPedido)) {
                break;
            }
            System.out.println("Respuesta no válida. Por favor, introduzca 'mayorista' o 'minorista'.");
        }

        // Mensajes personalizados según el tipo de pedido
        if ("mayorista".equals(tipoPedido)) {
            System.out.println("Creando pedido mayorista... Cargando lista de precios...");
        } else {
            System.out.println("Creando pedido minorista... Cargando lista de precios...");
        }

        System.out.println(" ");
        var pedido = pedidoService.crearPedido(primerUsuario);
        System.out.println("Pedido creado con ID: " + pedido.getId() + " y estado inicial: " + pedido.getEstado().name());

        System.out.println("¿Quieres pasar el pedido a pendiente de aprobación? (si/no)");
        System.out.println(" ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if ("si".equals(respuesta)) {
            if (pedidoService.cambiarEstadoPedido(pedido.getId(), EstadoPedido.PENDIENTE_APROBACION)) {
                System.out.println("Pedido ahora en estado: " + pedido.getEstado().name());
                System.out.println("Introduce el nombre del revisor (no puede ser " + primerNombre + "):");
                System.out.println(" ");
                String segundoNombre;
                while (true) {
                    segundoNombre = scanner.nextLine().trim();
                    if (!segundoNombre.equalsIgnoreCase(primerNombre)) {
                        break;
                    }
                    System.out.println("El nombre no puede ser el mismo que el del creador del pedido. Por favor, introduzca otro nombre:");
                }

                Usuario segundoUsuario = usuarioService.crearUsuario(segundoNombre);
                System.out.println("Revisor: ID " + segundoUsuario.getId() + ", Nombre: " + segundoUsuario.getNombre());
                System.out.println(" ");
                while (true) {
                    System.out.println("¿El revisor aprueba el pedido? (aprobado/rechazado)");
                    String decision = scanner.nextLine().trim().toLowerCase();
                    if ("aprobado".equals(decision) || "rechazado".equals(decision)) {
                        pedidoService.cambiarEstadoPedido(pedido.getId(), "aprobado".equals(decision) ? EstadoPedido.APROBADO : EstadoPedido.RECHAZADO);
                        System.out.println(" ");
                        System.out.println("Pedido finalmente en estado: " + pedido.getEstado().name());
                        break;
                    } else {
                        System.out.println("Respuesta no válida. Por favor, introduzca 'aprobado' o 'rechazado'.");
                    }
                }
            } else {
                System.out.println("No se pudo cambiar el estado del pedido.");
            }
        } else if ("no".equals(respuesta)) {
            System.out.println("El pedido permanece en estado: " + pedido.getEstado().name());
        } else {
            System.out.println("Respuesta no reconocida, no se realizan cambios en el estado del pedido.");
        }

        scanner.close();
    }
}
