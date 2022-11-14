package practica.mintic2022.msbeseguridad.repositorios;

import practica.mintic2022.msbeseguridad.modelos.PermisoRol;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepoPermisoRol extends MongoRepository<PermisoRol, String>{
    @Query("{'rol.$id': ObjectId(?0), 'permission.$id': ObjectId(?1)}")
    PermisoRol getPermissionRol(String id_rol, String id_permission);
}
