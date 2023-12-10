package co.unicauca.SeguimientoAcciones.domain.ports;

import co.unicauca.SeguimientoAcciones.domain.model.Accion;

import java.util.List;

public interface IBolsaValoresRepository {
    boolean saveAction(Accion action);
    boolean editAction(String nombreAccion, long precioActual);
    Accion findAction(String nombreAccion);
    List<Accion> findAllActions();
}
