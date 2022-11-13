package practica.mintic2022.msbeseguridad.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Setter;
import lombok.AccessLevel;

@Document
@Data
public class Rol {
    @Id
    @Setter(AccessLevel.NONE) //le establezco acces none para qeu no pued amodificarse el id
    private String _id;

    private String descripcion;
    private String tipo;

}
