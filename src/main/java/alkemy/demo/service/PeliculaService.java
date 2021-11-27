/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkemy.demo.service;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.entity.Pelicula;
import alkemy.demo.mapper.PeliculaMapper;
import alkemy.demo.repository.PeliculaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {
    
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private PeliculaMapper peliculaMapper;
    
    public PeliculaDTO registar(PeliculaDTO dto){
        Pelicula pelicula = peliculaMapper.peliculaDTO2Entity(dto);
        Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
        PeliculaDTO resultado = peliculaMapper.peliculaEntity2DTO(peliculaGuardada);
        return resultado;
    }
    
    public List<PeliculaDTO> listarTodo(){
        List<Pelicula> peliculas = peliculaRepository.findAll();
        List<PeliculaDTO> resultado = peliculaMapper.peliculaDTO2EntityList(peliculas);
        return resultado;
    }
    
    public void borrarPelicula(String id){
        peliculaRepository.deleteById(id);
    }
    
}
