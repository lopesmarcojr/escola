package com.escola.service.impl;

import com.escola.model.Aluno;
import com.escola.model.Endereco;
import com.escola.model.Professor;
import com.escola.repository.EnderecoRepository;
import com.escola.repository.ProfessorRepository;
import com.escola.service.ProfessorService;
import com.escola.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    @Override
    public Professor buscarPorMatricula(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.get();
    }
    @Override
    public void inserirProfessor(Professor professor) {
        salvarProfessorComCep(professor);
    }

    @Override
    public void atualizarProfessor(Long id, Professor professor) {
        Optional<Professor> professorById = professorRepository.findById(id);
        if(professorById.isPresent()){
            salvarProfessorComCep(professor);
        }
    }
    @Override
    public void excluirProfessor(Long id) {
        professorRepository.deleteById(id);
    }
    private void salvarProfessorComCep(Professor professor){
        String cep = professor.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        professor.setEndereco(endereco);
        professorRepository.save(professor);
    }
}
