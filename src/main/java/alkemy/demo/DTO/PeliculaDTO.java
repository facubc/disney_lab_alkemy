
package alkemy.demo.DTO;

import alkemy.demo.entity.Personaje;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class PeliculaDTO {
    private String id;
    private String titulo;
    private String imagen;
    
    private Integer calificacion;
    
    
    private Date creado;
        
    private List<Personaje> personajes;
}
