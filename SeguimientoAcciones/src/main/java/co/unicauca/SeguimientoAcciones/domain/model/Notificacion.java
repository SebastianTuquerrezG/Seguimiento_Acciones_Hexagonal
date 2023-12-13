package co.unicauca.SeguimientoAcciones.domain.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Notificacion implements Serializable{
    private int idUsuario;
    private String titulo;
    private String descripcion;
}

