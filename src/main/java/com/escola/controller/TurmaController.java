package com.escola.controller;

import com.escola.model.Turma;
import com.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("turmas")
public class TurmaController {
    @Autowired(required = false)
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<Iterable<Turma>> buscarPorTodasAsTurmas(){
        return ResponseEntity.ok(turmaService.buscarTodasAsTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarTurmaPorId(@PathVariable Long id){
        return ResponseEntity.ok(turmaService.buscarTurmaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Turma> inserirNovaTurma(@RequestBody Turma turma){
        turmaService.inserirTurma(turma);
        return ResponseEntity.ok(turma);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Turma> alterarTurma(@PathVariable Long id, @RequestBody Turma turma){
        turmaService.alterarTurma(id, turma);
        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id){
        turmaService.deletarTurma(id);
        return ResponseEntity.ok().build();
    }
}
