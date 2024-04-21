package main.java.com.ayiGroup.GolosinasApp.server;

import com.sun.net.httpserver.HttpServer;

import main.java.com.ayiGroup.GolosinasApp.service.PedidoService;
import main.java.com.ayiGroup.GolosinasApp.service.UsuarioService;

import java.net.InetSocketAddress;
import java.io.IOException;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        UsuarioService usuarioService = new UsuarioService();
        PedidoService pedidoService = new PedidoService(usuarioService);

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/cambiarEstado", new EstadoHandler(pedidoService));
        server.setExecutor(null); 
        server.start();
        System.out.println("Server started on port 8000");
    }
}
