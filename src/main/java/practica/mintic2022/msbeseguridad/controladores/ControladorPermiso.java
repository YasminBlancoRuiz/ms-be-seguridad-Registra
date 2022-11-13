package practica.mintic2022.msbeseguridad.controladores;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.ciclo4.ms_seguridad.modelos.Permiso;
import edu.ciclo4.ms_seguridad.repositorios.RepoPermiso;
import lombok.extern.apachecommons.CommonsLog;

import org.springframework.http.HttpStatus;
@CommonsLog
@CrossOrigin
@RestController
@RequestMapping("/permisos")
public class ControladorPermiso {
    @Autowired 
    private RepoPermiso repositorioPermiso;
    
    @GetMapping("")
    public List<Permiso> index(){
        log.debug("[GET /permisos]");
        return this.repositorioPermiso.findAll();
    }
    @GetMapping("{id}")
    public Permiso show(@PathVariable String id){
        log.debug("[GET /permisos"+ id +"]");
        Permiso permisolActual=this.repositorioPermiso
                        .findById(id)
                        .orElse(null);
        return permisolActual;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso create(@RequestBody  Permiso infoPermiso){
        log.debug("[POST /permisos]");
        return this.repositorioPermiso.save(infoPermiso);
    }
    @PutMapping("{id}")
    public Permiso update(@PathVariable String id,@RequestBody  Permiso infoPermiso){
        log.debug("[PUT /permisos]" +id+"]" + infoPermiso);
        Permiso permisoActual=this.repositorioPermiso
                .findById(id)
                .orElse(null);
        if (permisoActual!=null){
            permisoActual.setUrl(infoPermiso.getUrl());
            permisoActual.setMetodo(infoPermiso.getMetodo());
            return this.repositorioPermiso.save(permisoActual);
        }else{
            return  null;
        }
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        log.debug("DELETE /permisos" + id + "]");
        Permiso permisoActual=this.repositorioPermiso
                .findById(id)
                .orElse(null);
        if (permisoActual!=null){
            this.repositorioPermiso.delete(permisoActual);
        }
    }

}