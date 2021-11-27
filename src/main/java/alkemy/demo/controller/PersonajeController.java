
package alkemy.demo.controller;

import alkemy.demo.DTO.PersonajeDTO;
import alkemy.demo.DTO.PersonajeTinyDTO;
import alkemy.demo.service.PersonajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("character")
public class PersonajeController {
    
    @Autowired
    private PersonajeService personajeService;
    
    
    @GetMapping("/characters")
    public ResponseEntity<List<PersonajeTinyDTO>> getAll(){
        List<PersonajeTinyDTO> personajesDTO = personajeService.findAll();
        return ResponseEntity.ok().body(personajesDTO);
    }
        
    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeRegistrar = personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeRegistrar);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@PathVariable String id, @RequestBody PersonajeDTO dto){
        PersonajeDTO personaje = personajeService.update(id, dto);
        return ResponseEntity.ok().body(personaje);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hardDelete(@PathVariable String id){
        personajeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
