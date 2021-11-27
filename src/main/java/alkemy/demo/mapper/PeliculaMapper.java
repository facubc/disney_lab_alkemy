package alkemy.demo.mapper;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.DTO.PeliculaTinyDTO;
import alkemy.demo.entity.Pelicula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {

    public Pelicula peliculaDTO2Entity(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(dto.getTitulo());
        pelicula.setImagen(dto.getImagen());
        pelicula.setCalificacion(dto.getCalificacion());
        pelicula.setCreado(dto.getCreado());
        pelicula.setPersonajes(dto.getPersonajes());
        return pelicula;
    }

    public PeliculaDTO peliculaEntity2DTO(Pelicula pelicula) {
        PeliculaDTO dto = new PeliculaDTO();
        dto.setId(pelicula.getId());
        dto.setTitulo(pelicula.getTitulo());
        dto.setImagen(pelicula.getImagen());
        dto.setCalificacion(pelicula.getCalificacion());
        dto.setCreado(pelicula.getCreado());
        dto.setPersonajes(pelicula.getPersonajes());
        return dto;
    }

    public PeliculaTinyDTO peliculEntity2TinyDTO(Pelicula pelicula) {
        PeliculaTinyDTO dto = new PeliculaTinyDTO();
        dto.setTitulo(pelicula.getTitulo());
        dto.setImagen(pelicula.getImagen());
        dto.setCreado(pelicula.getCreado());
        return dto;
    }

    public List<PeliculaTinyDTO> peliculaEntity2DTOList(List<Pelicula> peliculas) {
        List<PeliculaTinyDTO> dtoList = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            dtoList.add(peliculEntity2TinyDTO(pelicula));
        }
        return dtoList;
    }

}
