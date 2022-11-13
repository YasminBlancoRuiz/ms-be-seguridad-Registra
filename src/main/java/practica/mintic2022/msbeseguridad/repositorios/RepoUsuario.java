package practica.mintic2022.msbeseguridad.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import practica.mintic2022.msbeseguridad.modelos.Usuario;
public interface RepoUsuario extends MongoRepository <Usuario, String>{
    
}
