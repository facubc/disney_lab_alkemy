
package alkemy.demo.entidades;

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
    String id;
    
    String nombre;
    String hitoria;
    String foto;    
    
    Integer edad;
    
    Double peso;    
    
    @OneToMany
    List<Pelicula> peliculas;
    
}
