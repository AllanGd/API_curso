package com.allan.cursoAPI.service;

import com.allan.cursoAPI.domain.Curso;
import com.allan.cursoAPI.repositories.CursoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CursoService {

    CursoRepository repository;

    public List<Curso> ListarCursos(){
        return repository.findAll();
    }

    public Optional<Curso> procurarCursoPorId(Integer id){
        return repository.findById(id);
    }

    public Curso inserirCurso(Curso curso){
        curso.setIdCurso(null);
        return repository.save(curso);
    }

    public void deletarCursoPorId(Integer id){
        repository.deleteById(id);
    }
}
