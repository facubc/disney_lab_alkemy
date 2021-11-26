
package alkemy.demo.controller;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.service.PeliculaService;
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
@RequestMapping("/pelicula")
public class PeliculaController {
    
    @Autowired
    private PeliculaService peliculaService;
    
//    @GetMapping
//    public ResponseEntity<List<PeliculaDTO>> listar(){
//        List<PeliculaDTO> peliculasDTO = PeliculaService.listarTodo();
//        return ResponseEntity.ok().body(peliculasDTO);
//    } 
    
    @PostMapping
    public ResponseEntity<PeliculaDTO> guardar(@RequestBody PeliculaDTO personaje){
        PeliculaDTO peliculaRegistrar = peliculaService .registar(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaRegistrar);
    }
    
}
