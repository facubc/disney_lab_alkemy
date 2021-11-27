
package alkemy.demo.mapper;

import alkemy.demo.DTO.GeneroDTO;
import alkemy.demo.entity.Genero;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {
    
    public Genero generoDTO2Entity(GeneroDTO dto){
        Genero genero = new Genero();
        genero.setNombre(dto.getNombre());
        genero.setImagen(dto.getImagen());
        genero.setPeliculas(dto.getPeliculas());
        return genero;
    }
    
    public GeneroDTO generoEntity2DTO(Genero genero){
        GeneroDTO dto = new GeneroDTO();
        dto.setId(genero.getId());
        dto.setNombre(genero.getNombre());
        dto.setImagen(genero.getImagen());
        dto.setPeliculas(genero.getPeliculas());
        return dto;
    }
    
    public List<GeneroDTO> generoEntity2DTOList(List<Genero> generos){
        List<GeneroDTO> dtoList = new ArrayList<>();
        for (Genero genero : generos) {
            dtoList.add(generoEntity2DTO(genero));
        }
        return dtoList;
    }
    
}
