package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rest;

import co.unicauca.SeguimientoAcciones.infrastructure.adapters.repositories.SqlLiteRepository;
import co.unicauca.SeguimientoAcciones.domain.model.AccionUsuario;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accionUsuario")
public class AccionUsuarioController {

    private SqlLiteRepository sqlLiteRepository = new SqlLiteRepository();

    @PostMapping
    public void createAccionUsuario(@RequestBody @NonNull AccionUsuario accionUsuario) {
        sqlLiteRepository.saveActionUser(accionUsuario);
    }

    @DeleteMapping("/{idUsuario}/{nombreAccion}")
    public void deleteAccionUsuario(@PathVariable int idUsuario, @PathVariable String nombreAccion) {
        sqlLiteRepository.deleteActionUser(idUsuario, nombreAccion);
    }

    @GetMapping("/{idUsuario}")
    public List<AccionUsuario> listAccionUsuarios(@PathVariable int idUsuario){
        return sqlLiteRepository.findAllActionsUser(idUsuario);
    }
}
