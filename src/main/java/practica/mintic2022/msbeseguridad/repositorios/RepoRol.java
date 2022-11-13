package practica.mintic2022.msbeseguridad.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import practica.mintic2022.msbeseguridad.modelos.Rol;

public interface RepoRol  extends MongoRepository <Rol, String>{
    
}

