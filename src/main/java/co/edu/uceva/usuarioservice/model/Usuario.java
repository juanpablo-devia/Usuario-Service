package co.edu.uceva.usuarioservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long cedula;
    private String contrasena;
    private String correo;
    private String nombreCompleto;
    private String rol;
    private long telefono;
}
