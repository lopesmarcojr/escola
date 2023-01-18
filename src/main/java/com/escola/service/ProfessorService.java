package com.escola.service;

import com.escola.model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProfessorService {

    List<Professor> buscarTodos();

    Professor buscarPorMatricula(Long id);

    void inserirProfessor(Professor professor);

    void atualizarProfessor(Long id, Professor professor);

    void excluirProfessor(Long id);

}
