package alkemy.demo.service;

import alkemy.demo.DTO.GeneroDTO;
import alkemy.demo.entity.Genero;
import alkemy.demo.mapper.GeneroMapper;
import alkemy.demo.repository.GeneroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO registrar(GeneroDTO dto) {
        Genero genero = generoMapper.generoDTO2Entity(dto);
        Genero generoGuardado = generoRepository.save(genero);
        GeneroDTO resultado = generoMapper.generoEntity2DTO(generoGuardado);
        return resultado;
    }

    public List<GeneroDTO> listarTodo() {
        List<Genero> generos = generoRepository.findAll();
        List<GeneroDTO> resultado = generoMapper.generoEntity2DTOList(generos);
        return resultado;
    }

    public GeneroDTO modificar(String id, GeneroDTO dto) {
        Optional<Genero> respuesta = generoRepository.findById(id);
        GeneroDTO resultado = new GeneroDTO();
        if (respuesta.isPresent()) {
            Genero genero = respuesta.get();
            genero.setNombre(dto.getNombre());
            genero.setImagen(dto.getImagen());
            genero.setPeliculas(dto.getPeliculas());
            Genero generoModificado = generoRepository.save(genero);
            resultado = generoMapper.generoEntity2DTO(generoModificado);
        }        
        return resultado;
    }

    public void borrarGenero(String id) {
        generoRepository.deleteById(id);
    }

}
