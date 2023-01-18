package com.escola.service;

import com.escola.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {

    List<Aluno> buscarTodos();

    Aluno buscarPorMatricula(Long id);

    void inserirAluno(Aluno aluno);

    void atualizarAluno(Long id, Aluno aluno);

    void excluirAluno(Long id);
}
