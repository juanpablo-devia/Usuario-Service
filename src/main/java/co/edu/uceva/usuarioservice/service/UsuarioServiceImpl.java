package co.edu.uceva.usuarioservice.service;

import co.edu.uceva.usuarioservice.exception.ResourceNotFoundException;
import co.edu.uceva.usuarioservice.model.Usuario;
import co.edu.uceva.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {  // Usando camelCase estándar ("U" mayúscula)
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existing = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));

        existing.setCedula(usuario.getCedula());
        existing.setContrasena(usuario.getContrasena());
        existing.setCorreo(usuario.getCorreo());
        existing.setNombreCompleto(usuario.getNombreCompleto());
        existing.setRol(usuario.getRol());
        existing.setTelefono(usuario.getTelefono());

        return usuarioRepository.save(existing);
    }


    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}