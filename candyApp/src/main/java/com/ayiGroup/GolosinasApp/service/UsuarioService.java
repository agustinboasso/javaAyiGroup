package main.java.com.ayiGroup.GolosinasApp.service;

import main.java.com.ayiGroup.GolosinasApp.model.Usuario;

public class UsuarioService {
    private int ultimoId = 0; 

    public Usuario crearUsuario(String nombre) {
        ultimoId++; 
        return new Usuario(ultimoId, nombre);
    }
}