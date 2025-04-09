package co.edu.uceva.usuarioservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private Long cedula;
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String rol;
    private Long telefono;
}