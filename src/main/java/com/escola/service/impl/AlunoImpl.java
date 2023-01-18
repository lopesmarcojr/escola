package com.escola.service.impl;

import com.escola.model.Aluno;
import com.escola.model.Endereco;
import com.escola.repository.AlunoRepository;
import com.escola.repository.EnderecoRepository;
import com.escola.service.AlunoService;
import com.escola.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarPorMatricula(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.get();
    }

    @Override
    public void inserirAluno(Aluno aluno) {
        salvarAlunoComCep(aluno);

    }

    @Override
    public void atualizarAluno(Long id, Aluno aluno) {
        Optional<Aluno> alunoById = alunoRepository.findById(id);
        if(alunoById.isPresent()){
            salvarAlunoComCep(aluno);
        }
    }

    @Override
    public void excluirAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    private void salvarAlunoComCep(Aluno aluno){
        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        aluno.setEndereco(endereco);
        alunoRepository.save(aluno);
    }
}
