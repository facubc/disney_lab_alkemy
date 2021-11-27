
package alkemy.demo.service;

import alkemy.demo.DTO.PersonajeDTO;
import alkemy.demo.DTO.PersonajeTinyDTO;
import alkemy.demo.entity.Personaje;
import alkemy.demo.mapper.PersonajeMapper;
import alkemy.demo.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonajeService {
    
    @Autowired
    private PersonajeMapper personajeMapper;
    
    @Autowired
    private PersonajeRepository personajeRepository;
        
    @Transactional
    public PersonajeDTO save(PersonajeDTO dto){
        Personaje personaje = personajeMapper.personajeDTO2Entity(dto);
        Personaje personajeGuardado = personajeRepository.save(personaje);
        PersonajeDTO resultado = personajeMapper.personajeEntity2DTO(personajeGuardado);
        return resultado;
    }
    
    @Transactional(readOnly = true)
    public List<PersonajeTinyDTO> findAll(){
        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeTinyDTO> resultado = personajeMapper.personajeEntity2DTOList(personajes);
        return resultado;
    }
    
    @Transactional
    public PersonajeDTO update(String id, PersonajeDTO dto) {
        Optional<Personaje> respuesta = personajeRepository.findById(id);
        PersonajeDTO resultado = new PersonajeDTO();
        if (respuesta.isPresent()) {
            Personaje personaje = respuesta.get();
            personaje.setNombre(dto.getNombre());
            personaje.setHitoria(dto.getHitoria());
            personaje.setFoto(dto.getFoto());
            personaje.setEdad(dto.getEdad());
            personaje.setPeso(dto.getPeso());
            personaje.setPeliculas(dto.getPeliculas());
            Personaje personajeModificado = personajeRepository.save(personaje);
            resultado = personajeMapper.personajeEntity2DTO(personajeModificado);
        }        
        return resultado;
    }
    
    @Transactional
    public void deleteById(String id){
        personajeRepository.deleteById(id);
    }
    
}
