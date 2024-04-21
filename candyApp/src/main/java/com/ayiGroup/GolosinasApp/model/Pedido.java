package main.java.com.ayiGroup.GolosinasApp.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int id;
    private EstadoPedido estado;
    private List<String> golosinas; 
    private Usuario solicitante;

    public Pedido(int id, Usuario solicitante) {
        this.id = id;
        this.estado = EstadoPedido.BORRADOR;
        this.golosinas = new ArrayList<>();
        this.solicitante = solicitante;
    }

    
    public void agregarGolosina(String golosina) {
        golosinas.add(golosina);
    }

    public boolean removerGolosina(String golosina) {
        return golosinas.remove(golosina);
    }

    
    public int getId() {
        return id;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public List<String> getGolosinas() {
        return new ArrayList<>(golosinas);
    }

    
}
