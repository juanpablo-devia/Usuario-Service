package co.edu.uceva.usuarioservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {
    private Long id;
    private Long cedula;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String rol;
    private Long telefono;
}