package co.edu.uceva.usuarioservice.service;

import co.edu.uceva.usuarioservice.exception.ResourceNotFoundException;
import co.edu.uceva.usuarioservice.model.Usuario;
import co.edu.uceva.usuarioservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
    }

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Page<Usuario> obtenerUsuariosPaginados(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario nuevo) {
        Usuario existente = obtenerUsuarioPorId(id);
        existente.setCedula(nuevo.getCedula());
        existente.setNombreCompleto(nuevo.getNombreCompleto());
        existente.setCorreo(nuevo.getCorreo());
        existente.setContrasena(nuevo.getContrasena());
        existente.setRol(nuevo.getRol());
        existente.setTelefono(nuevo.getTelefono());
        return usuarioRepository.save(existente);
    }

    @Override
    public void eliminarUsuario(Long id) {
        obtenerUsuarioPorId(id);
        usuarioRepository.deleteById(id);
    }
}