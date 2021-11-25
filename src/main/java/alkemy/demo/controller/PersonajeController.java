
package alkemy.demo.controller;

import alkemy.demo.DTO.PersonajeDTO;
import alkemy.demo.service.PersonajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personaje")
public class PersonajeController {
    
    @Autowired
    private PersonajeService personajeService;
    
    
    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> listar(){
        List<PersonajeDTO> personajesDTO = personajeService.listarTodo();
        return ResponseEntity.ok().body(personajesDTO);
    }
        
    @PostMapping
    public ResponseEntity<PersonajeDTO> guardar(@RequestBody PersonajeDTO personaje){
        PersonajeDTO personajeRegistrar = personajeService.registar(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeRegistrar);
    }
    
}
