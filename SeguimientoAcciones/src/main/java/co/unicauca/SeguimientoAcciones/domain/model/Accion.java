package co.unicauca.SeguimientoAcciones.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Accion{
    private String nombreAccion;
    private long precioActual;
    private long precioAnterior;
}
