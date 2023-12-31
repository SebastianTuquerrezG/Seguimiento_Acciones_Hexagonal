package co.unicauca.SeguimientoAcciones.domain.ports;
import co.unicauca.SeguimientoAcciones.domain.model.*;

import java.util.List;

public interface IGestionAccionesRepository {
    boolean saveUser(Usuario user);
    boolean editUmbrales(int idUsuario, String nombreAccion, int USuperor, int UInferior);
    boolean saveActionUser(AccionUsuario accionUsuario);
    boolean deleteActionUser(int idUsuario, String nombreAccion);
    AccionUsuario findActionUser(int idUsuario, String nombreAccion);
    List<AccionUsuario> findAllActionsUser(int idUsuario);
    List<AccionUsuario> findAllUsersAction(String nombreAccion);
    boolean saveNotification(int idUsuario, Notificacion notificacion);
    List<Notificacion> findAllNotifications(int idUsuario);
}
