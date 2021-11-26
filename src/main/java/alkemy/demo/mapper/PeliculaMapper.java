
package alkemy.demo.mapper;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.entity.Pelicula;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {
    
    public Pelicula peliculaDTO2Entity(PeliculaDTO dto){
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setImagen(dto.getImagen());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setCreado(dto.getCreado());
        pelicula.setPersonajes(dto.getPersonajes());
        return pelicula;        
    }
    
    public PeliculaDTO peliculaEntity2DTO(Pelicula pelicula){
        PeliculaDTO dto = new PeliculaDTO();
        dto.setTitulo(pelicula.getTitulo());
        dto.setImagen(pelicula.getImagen());
        dto.setCalificacion(pelicula.getCalificacion());
        dto.setCreado(pelicula.getCreado());
        dto.setPersonajes(pelicula.getPersonajes());
        return dto;
    }
    
    //todo para modificar a list
    public Pelicula peliculaDTO2EntityList(PeliculaDTO dto){
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setImagen(dto.getImagen());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setCreado(dto.getCreado());
        pelicula.setPersonajes(dto.getPersonajes());
        return pelicula;
    }
    
}
