
package alkemy.demo.DTO;

import alkemy.demo.entity.Pelicula;
import java.util.List;
import lombok.Data;

@Data
public class GeneroDTO {
    
    private String id;    
    private String nombre;
    private String imagen;   
    private List<Pelicula> peliculas;
}
