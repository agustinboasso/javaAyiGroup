package main.java.com.ayiGroup.GolosinasApp.service;

import main.java.com.ayiGroup.GolosinasApp.model.Usuario;

public class UsuarioService {

    public Usuario obtenerUsuarioPorId(int id) {
        // En una aplicación real, aquí buscarías el usuario en la base de datos.
        // Esta es solo una simulación.
        return new Usuario(id, "NombreUsuario" + id);
    }
}
