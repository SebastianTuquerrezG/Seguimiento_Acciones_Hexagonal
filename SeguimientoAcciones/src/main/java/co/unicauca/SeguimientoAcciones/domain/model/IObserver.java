package co.unicauca.SeguimientoAcciones.domain.model;

public interface IObserver {

    void notificar(String nombreAccion, long precioActual);
}
