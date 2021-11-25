
package alkemy.demo.DTO;

import alkemy.demo.entity.Pelicula;
import java.util.List;
import lombok.Data;


@Data
public class PersonajeDTO {

    private String id;    
    private String nombre;
    private String hitoria;
    private String foto;    
    private Integer edad;
    private Double peso;    
    private List<Pelicula> peliculas;
    
}
