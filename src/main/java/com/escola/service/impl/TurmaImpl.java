package com.escola.service.impl;

import com.escola.model.Turma;
import com.escola.repository.TurmaRepository;
import com.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurmaImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    @Override
    public List<Turma> buscarTodasAsTurmas() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma buscarTurmaPorId(Long id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        return turma.get();
    }

    @Override
    public void inserirTurma(Turma turma) {
        turmaRepository.save(turma);
    }

    @Override
    public void alterarTurma(Long id, Turma turma) {
        Optional<Turma> turmaById = turmaRepository.findById(id);
        if(turmaById.isPresent()){
            turmaRepository.save(turma);
        }else{
            System.out.println("Turma não existe no sistema da escola");
        }
    }

    @Override
    public void deletarTurma(Long id) {
        turmaRepository.deleteById(id);
    }
}
