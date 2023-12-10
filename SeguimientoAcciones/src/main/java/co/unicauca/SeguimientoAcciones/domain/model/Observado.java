package co.unicauca.SeguimientoAcciones.domain.model;

public abstract class Observado {

    public abstract void addObserver(IObserver observer);

    public abstract void deleteObserver(IObserver observer);

    public abstract void notifyObservers();
}
