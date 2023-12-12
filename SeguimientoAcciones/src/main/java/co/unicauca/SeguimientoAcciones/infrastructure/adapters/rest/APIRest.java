package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rest;

import co.unicauca.SeguimientoAcciones.domain.model.Accion;
import co.unicauca.SeguimientoAcciones.domain.model.AccionUsuario;
import co.unicauca.SeguimientoAcciones.domain.model.Usuario;
import co.unicauca.SeguimientoAcciones.infrastructure.adapters.repositories.BolsaValoresRepository;
import co.unicauca.SeguimientoAcciones.infrastructure.adapters.repositories.SqlLiteRepository;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIRest {
    private BolsaValoresRepository bolsaValoresRepository = new BolsaValoresRepository();
    private SqlLiteRepository sqlLiteRepository = new SqlLiteRepository(bolsaValoresRepository);

    //SERVICIOS REST DE ACCIONES
    @PostMapping("/accion")
    public void createAccion(@RequestBody @NonNull Accion action){
        sqlLiteRepository.getBolsaValoresRepository().saveAction(action);
    }

    @PutMapping("/accion/{nombreAccion}-{precioActual}")
    public void editAccion(@PathVariable String nombreAccion, @PathVariable long precioActual){
        List<AccionUsuario> users = sqlLiteRepository.findAllUsersAction(nombreAccion);
        for(AccionUsuario auxUser: users){
            if(auxUser.getUsuario().getId()==21){
                auxUser.notificar(nombreAccion,precioActual);
            }
        }
        sqlLiteRepository.getBolsaValoresRepository().editAction(nombreAccion, precioActual);
    }

    @GetMapping("/accion/{nombreAccion}")
    public Accion findAccion(@PathVariable String nombreAccion){
        return sqlLiteRepository.getBolsaValoresRepository().findAction(nombreAccion);
    }

    @GetMapping("/accion")
    public List<Accion> list() {
        return sqlLiteRepository.getBolsaValoresRepository().findAllActions();
    }

    //SERVICIOS REST DE ACCIONES USUARIO
    @PostMapping("/accionUsuario")
    public void createAccionUsuario(@RequestBody @NonNull AccionUsuario accionUsuario) {
        Accion action = sqlLiteRepository.getBolsaValoresRepository().findAction(accionUsuario.getAccion().getNombreAccion());
        if(action!=null){
            sqlLiteRepository.saveActionUser(accionUsuario);
        }

    }

    @DeleteMapping("/accionUsuario/{idUsuario}/{nombreAccion}")
    public void deleteAccionUsuario(@PathVariable int idUsuario, @PathVariable String nombreAccion) {
        sqlLiteRepository.deleteActionUser(idUsuario, nombreAccion);
    }

    @GetMapping("/accionUsuario/{idUsuario}")
    public List<AccionUsuario> listAccionUsuarios(@PathVariable int idUsuario){
        return sqlLiteRepository.findAllActionsUser(idUsuario);
    }

    //SERVICIOS REST DE USUARIOS
    @PostMapping("/usuario")
    public void createUsuario(@RequestBody @io.micrometer.common.lang.NonNull Usuario user){
        sqlLiteRepository.saveUser(user);
    }
}
