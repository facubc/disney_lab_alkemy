
package alkemy.demo.service;

import alkemy.demo.DTO.PersonajeDTO;
import alkemy.demo.entity.Personaje;
import alkemy.demo.mapper.PersonajeMapper;
import alkemy.demo.repository.PersonajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    
    @Autowired
    private PersonajeMapper personajeMapper;
    
    @Autowired
    private PersonajeRepository personajeRepository;
        
    public PersonajeDTO registar(PersonajeDTO dto){
        Personaje personaje = personajeMapper.personajeDTO2Entity(dto);
        Personaje personajeGuardado = personajeRepository.save(personaje);
        PersonajeDTO resultado = personajeMapper.personajeEntity2DTO(personajeGuardado);
        return resultado;
    }
    
    public List<PersonajeDTO> listarTodo(){
        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeDTO> resultado = personajeMapper.personajeDTO2EntityList(personajes);
        return resultado;
    }
    
    public void borrarPersonaje(String id){
        personajeRepository.deleteById(id);
    }
    
}
