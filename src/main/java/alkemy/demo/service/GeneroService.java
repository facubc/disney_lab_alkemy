package alkemy.demo.service;

import alkemy.demo.DTO.GeneroDTO;
import alkemy.demo.entity.Genero;
import alkemy.demo.mapper.GeneroMapper;
import alkemy.demo.repository.GeneroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroService {

    @Autowired
    private GeneroMapper generoMapper;

    @Autowired
    private GeneroRepository generoRepository;

    @Transactional
    public GeneroDTO save(GeneroDTO dto) {
        Genero genero = generoMapper.generoDTO2Entity(dto);
        Genero generoGuardado = generoRepository.save(genero);
        GeneroDTO resultado = generoMapper.generoEntity2DTO(generoGuardado);
        return resultado;
    }

    @Transactional(readOnly = true)
    public List<GeneroDTO> findAll() {
        List<Genero> generos = generoRepository.findAll();
        List<GeneroDTO> resultado = generoMapper.generoEntity2DTOList(generos);
        return resultado;
    }

    @Transactional
    public GeneroDTO update(String id, GeneroDTO dto) {
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

    @Transactional
    public void deleteById(String id) {
        generoRepository.deleteById(id);
    }

}
