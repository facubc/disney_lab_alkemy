
package alkemy.demo.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data //get y set
@AllArgsConstructor // constructor completo
@NoArgsConstructor // constructtor vacio
@Entity
public class Personaje {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String nombre;
    private String hitoria;
    private String foto;    
    
    private Integer edad;
    
    private Double peso;    
    
    @OneToMany
    private List<Pelicula> peliculas;
    
}
