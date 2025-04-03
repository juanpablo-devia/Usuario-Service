package co.edu.uceva.usuarioservice.service;

import co.edu.uceva.usuarioservice.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario saveUsuario(Usuario usuario);//
    List<Usuario> getAllUsuarios();  //
    Usuario getUsuarioById(Long id);
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);
}
