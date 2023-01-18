package com.escola.service;

import com.escola.model.Turma;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EscolaService {
    List<Turma> buscarTodasAsTurmas();

    Turma buscarTurmaPorId(Long id);

    void inserirTurma(Turma turma);

    void alterarTurma(Long id, Turma turma);

    void deletarTurma(Long id);
}
