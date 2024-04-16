package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.AlunoEntity;

import java.util.List;

public interface AlunoService {

    AlunoEntity criarAluno(AlunoEntity aluno);

    List<AlunoEntity> listarAlunos();

    AlunoEntity buscarAlunoPorId(Long id);

    AlunoEntity atualizarAluno(Long id, AlunoEntity aluno);

    void excluirAluno(Long id);

}
