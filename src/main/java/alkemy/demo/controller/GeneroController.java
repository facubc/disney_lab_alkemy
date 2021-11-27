
package alkemy.demo.controller;

import alkemy.demo.DTO.GeneroDTO;
import alkemy.demo.service.GeneroService;
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
@RequestMapping("genre")
public class GeneroController {
    
    @Autowired
    GeneroService generoService;
    
    @GetMapping("/genres")
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generosDTO = generoService.findAll();
        return ResponseEntity.ok().body(generosDTO);
    }    
    
    @PostMapping
    public ResponseEntity<GeneroDTO> save(@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }    
    
    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@PathVariable String id, @RequestBody GeneroDTO dto){
        GeneroDTO genero = generoService.update(id, dto);
        return ResponseEntity.ok().body(genero);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hardDelete(@PathVariable String id){
        generoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
