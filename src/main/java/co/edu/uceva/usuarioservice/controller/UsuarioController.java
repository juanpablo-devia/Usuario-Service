package co.edu.uceva.usuarioservice.controller;

import co.edu.uceva.usuarioservice.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.uceva.usuarioservice.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioService.saveUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable long id){
        return usuarioService.getUsuarioById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable long id){
        usuarioService.deleteUsuario(id);
    }
}

