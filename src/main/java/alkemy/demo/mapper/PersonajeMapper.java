
package alkemy.demo.mapper;

import alkemy.demo.DTO.PersonajeDTO;
import alkemy.demo.entity.Personaje;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class PersonajeMapper {
    
    /**
    * personajeDTO2Entity 
    * transforma DTO a Entidad    
    * @param dto recibe Objeto de tipo DTO
    * @return devuelve Objeto de tipo Personaje
    */
    public Personaje personajeDTO2Entity(PersonajeDTO dto){
        Personaje personaje = new Personaje();
        personaje.setNombre(dto.getNombre());
        personaje.setHitoria(dto.getHitoria());
        personaje.setFoto(dto.getFoto());
        personaje.setEdad(dto.getEdad());
        personaje.setPeso(dto.getPeso());
        personaje.setPeliculas(dto.getPeliculas());
        return personaje;
    }
    
    
    //transforma Entidad a DTO
    public PersonajeDTO personajeEntity2DTO(Personaje personaje){
        PersonajeDTO dto = new PersonajeDTO();
        dto.setId(personaje.getId());
        dto.setNombre(personaje.getNombre());
        dto.setHitoria(personaje.getHitoria());
        dto.setFoto(personaje.getFoto());
        dto.setEdad(personaje.getEdad());
        dto.setPeso(personaje.getPeso());
        dto.setPeliculas(personaje.getPeliculas());
        return dto;
    }
    
    //devuelve lista de DTO
    public List<PersonajeDTO> personajeDTO2EntityList(List<Personaje> personajes){
        List<PersonajeDTO> dtoList = new ArrayList<>();
        for (Personaje aux : personajes) {
            dtoList.add(personajeEntity2DTO(aux));
        }
        return dtoList;
    }
    
}
