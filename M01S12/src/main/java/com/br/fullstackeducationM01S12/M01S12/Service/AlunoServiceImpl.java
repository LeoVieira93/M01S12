package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.AlunoEntity;
import com.br.fullstackeducationM01S12.M01S12.Exception.NotFoundException;
import com.br.fullstackeducationM01S12.M01S12.Repository.AlunoRepository;
import com.br.fullstackeducationM01S12.M01S12.util.JsonUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@NoArgsConstructor(force = true)
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public AlunoEntity criarAluno(AlunoEntity alunoNovo) {
        alunoNovo.setId(null);
        AlunoEntity aluno = alunoRepository.save(alunoNovo);
        return aluno;
    }

    @Override
    public List<AlunoEntity> listarAlunos() {
        List<AlunoEntity> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Override
    public AlunoEntity buscarAlunoPorId(Long id) {
        Optional<AlunoEntity> aluno = alunoRepository.findById(id);
        if (aluno.isEmpty()) {
            return alunoRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Aluno não encontrado com o ID: " + id));
        }
        return aluno.get();
    }

    @Override
    public AlunoEntity atualizarAluno(Long id, AlunoEntity aluno) {
        if (!alunoRepository.existsById(id)) {
            throw new NotFoundException("Aluno não encontrado com o ID: " + id);
        }
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @Override
    public void excluirAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new NotFoundException("Aluno não encontrada com o ID: " + id);
        }
        alunoRepository.deleteById(id);
    }
}
