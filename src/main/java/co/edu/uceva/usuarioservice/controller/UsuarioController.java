package co.edu.uceva.usuarioservice.controller;

import co.edu.uceva.usuarioservice.dto.*;
import co.edu.uceva.usuarioservice.model.Usuario;
import co.edu.uceva.usuarioservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/usuario-service")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioResponse> crearUsuario(@RequestBody UsuarioRequest request) {
        Usuario nuevo = new Usuario();
        nuevo.setCedula(request.getCedula());
        nuevo.setNombreCompleto(request.getNombreCompleto());
        nuevo.setCorreo(request.getCorreo());
        nuevo.setContrasena(request.getContrasena());
        nuevo.setRol(request.getRol());
        nuevo.setTelefono(request.getTelefono());

        Usuario guardado = usuarioService.crearUsuario(nuevo);
        return ResponseEntity.ok(toResponse(guardado));
    }

    @GetMapping("/usuarios")
    public List<UsuarioResponse> obtenerTodos() {
        return usuarioService.obtenerTodosLosUsuarios().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(toResponse(usuario));
    }

    @GetMapping("/usuarios/page/{pagina}")
    public ResponseEntity<UsuarioPageResponse> obtenerPaginados(@PathVariable int pagina) {
        Pageable pageable = PageRequest.of(pagina, 10);
        var page = usuarioService.obtenerUsuariosPaginados(pageable);

        List<UsuarioResponse> contenido = page.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new UsuarioPageResponse(
                contenido,
                page.getTotalPages(),
                page.getTotalElements(),
                page.getNumber()
        ));
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setCedula(request.getCedula());
        usuario.setNombreCompleto(request.getNombreCompleto());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(request.getContrasena());
        usuario.setRol(request.getRol());
        usuario.setTelefono(request.getTelefono());

        Usuario actualizado = usuarioService.actualizarUsuario(id, usuario);
        return ResponseEntity.ok(toResponse(actualizado));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<DeleteResponse> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.ok(new DeleteResponse("Usuario con ID " + id + " eliminado correctamente"));
    }

    private UsuarioResponse toResponse(Usuario u) {
        return new UsuarioResponse(
                u.getId(),
                u.getCedula(),
                u.getNombreCompleto(),
                u.getCorreo(),
                u.getContrasena(),
                u.getRol(),
                u.getTelefono()
        );
    }
}