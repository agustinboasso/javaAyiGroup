package main.java.com.ayiGroup.GolosinasApp.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;
import main.java.com.ayiGroup.GolosinasApp.service.PedidoService;

public class EstadoHandler implements HttpHandler {
    private PedidoService pedidoService;

    public EstadoHandler(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String query = exchange.getRequestURI().getQuery();
            String[] params = query.split("&");
            int pedidoId = Integer.parseInt(params[0].split("=")[1]);

            
            EstadoPedido nuevoEstado = EstadoPedido.valueOf(params[1].split("=")[1]);

            String response;
            if (pedidoService.cambiarEstadoPedido(pedidoId, nuevoEstado)) {
                response = "Cambio de estado exitoso.";
            } else {
                response = "Cambio de estado no permitido.";
            } else {
                throw new ProcessingException(ExceptionDetail.CodigoError.ESTADO_LIQUIDACION_INVALIDO);
            }

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            String response = "Método no soportado";
            exchange.sendResponseHeaders(405, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
