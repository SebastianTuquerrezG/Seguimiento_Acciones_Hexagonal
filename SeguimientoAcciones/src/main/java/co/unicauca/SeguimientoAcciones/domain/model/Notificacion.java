package co.unicauca.SeguimientoAcciones.domain.model;

import lombok.Data;

@Data
public class Notificacion {
    private int idUsuario;
    private String titulo;
    private String descripcion;
}

