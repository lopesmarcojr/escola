package com.escola.service;

import com.escola.model.Turma;
import org.springframework.stereotype.Service;

@Service
public interface TurmaService {

    Iterable<Turma> buscarTodasAsTurmas();

    Turma buscarTurmaPorId(Long id);

    void inserirTurma(Turma turma);

    void alterarTurma(Long id, Turma turma);

    void deletarTurma(Long id);
}
