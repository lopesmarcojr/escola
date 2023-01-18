package com.escola.controller;

import com.escola.model.Professor;
import com.escola.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("professor")
public class EscolaController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<Iterable<Professor>> buscarTodosOsProfessores(){
        return ResponseEntity.ok(professorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id){
        return ResponseEntity.ok(professorService.buscarPorMatricula(id));
    }

    @PostMapping
    public ResponseEntity<Professor> inserirProfessor(@RequestBody Professor professor){
        professorService.inserirProfessor(professor);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> alterarProfessor(@PathVariable Long id, @RequestBody Professor professor){
        professorService.atualizarProfessor(id, professor);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id){
        professorService.excluirProfessor(id);
        return ResponseEntity.ok().build();
    }


}
