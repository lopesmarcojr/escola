package com.escola.controller;

import com.escola.model.Aluno;
import com.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodos(){
        return ResponseEntity.ok(alunoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.buscarPorMatricula(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> matricularNovoAluno(@RequestBody Aluno aluno){
        alunoService.inserirAluno(aluno);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
        alunoService.atualizarAluno(id, aluno);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
        return ResponseEntity.ok().build();
    }
}
