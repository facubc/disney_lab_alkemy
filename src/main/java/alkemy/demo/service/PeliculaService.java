/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkemy.demo.service;

import alkemy.demo.DTO.PeliculaDTO;
import alkemy.demo.DTO.PeliculaTinyDTO;
import alkemy.demo.entity.Pelicula;
import alkemy.demo.mapper.PeliculaMapper;
import alkemy.demo.repository.PeliculaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeliculaService {
    
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private PeliculaMapper peliculaMapper;
    
    @Transactional
    public PeliculaDTO save(PeliculaDTO dto){
        Pelicula pelicula = peliculaMapper.peliculaDTO2Entity(dto);
        Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
        PeliculaDTO resultado = peliculaMapper.peliculaEntity2DTO(peliculaGuardada);
        return resultado;
    }
    
    @Transactional(readOnly = true)
    public List<PeliculaTinyDTO> findAll(){
        List<Pelicula> peliculas = peliculaRepository.findAll();
        List<PeliculaTinyDTO> resultado = peliculaMapper.peliculaEntity2DTOList(peliculas);
        return resultado;
    }
    
    @Transactional
    public PeliculaDTO update(String id, PeliculaDTO dto) {
        Optional<Pelicula> respuesta = peliculaRepository.findById(id);
        PeliculaDTO resultado = new PeliculaDTO();
        if (respuesta.isPresent()) {
            Pelicula pelicula = respuesta.get();
            pelicula.setTitulo(dto.getTitulo());
            pelicula.setImagen(dto.getImagen());
            pelicula.setCreado(dto.getCreado());
            pelicula.setCalificacion(dto.getCalificacion());
            pelicula.setPersonajes(dto.getPersonajes());
            Pelicula peliculaModificada = peliculaRepository.save(pelicula);
            resultado = peliculaMapper.peliculaEntity2DTO(peliculaModificada);
        }        
        return resultado;
    }
    
    @Transactional
    public void deleteById(String id){
        peliculaRepository.deleteById(id);
    }
    
}
