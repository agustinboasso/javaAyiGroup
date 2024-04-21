package main.java.com.ayiGroup.GolosinasApp.utils;

import main.java.com.ayiGroup.GolosinasApp.model.EstadoPedido;

public class EstadoPedidoChecker {

    public static boolean puedeCambiar(EstadoPedido actual, EstadoPedido nuevo) {
        if (actual == EstadoPedido.BORRADOR && nuevo == EstadoPedido.PENDIENTE_APROBACION) {
            return true;
        } else if (actual == EstadoPedido.PENDIENTE_APROBACION && (nuevo == EstadoPedido.APROBADO || nuevo == EstadoPedido.RECHAZADO)) {
            return true;
        }
        
        return false;
    }
}