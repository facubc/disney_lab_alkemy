
package alkemy.demo.controller;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.DTO.PeliculaTinyDTO;
import alkemy.demo.service.PeliculaService;
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
@RequestMapping("movie")
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;
    
    @GetMapping("/movies")
    public ResponseEntity<List<PeliculaTinyDTO>> getAll(){
        List<PeliculaTinyDTO> peliculasDTO = peliculaService.findAll();
        return ResponseEntity.ok().body(peliculasDTO);
    } 
    
    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@RequestBody PeliculaDTO personaje){
        PeliculaDTO peliculaRegistrar = peliculaService .save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaRegistrar);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update(@PathVariable String id, @RequestBody PeliculaDTO dto){
        PeliculaDTO pelicula = peliculaService.update(id, dto);
        return ResponseEntity.ok().body(pelicula);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hardDelete(@PathVariable String id){
        peliculaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
