package com.allan.cursoAPI.controller;

import com.allan.cursoAPI.domain.Curso;
import com.allan.cursoAPI.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CursoController {

    CursoService service;

    @GetMapping("/curso")
    public ResponseEntity<List<Curso>> listarCursos(){
        List<Curso> obj = service.ListarCursos();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<?> buscarCurso(@PathVariable Integer id){
        Optional<Curso> curso = service.procurarCursoPorId(id);
        return ResponseEntity.ok().body(curso);
    }

    @PostMapping("/curso")
    public ResponseEntity<Void> inserirCurso(@RequestBody Curso curso){
        curso = service.inserirCurso(curso);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getIdCurso()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/curso/{id}")
    public void deletarCurso(@PathVariable Integer id){
        service.deletarCursoPorId(id);
    }
}
