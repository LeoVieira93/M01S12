package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.ProfessorEntity;

import java.util.List;

public interface ProfessorService {

    ProfessorEntity criarProfessor(ProfessorEntity professor);
    List<ProfessorEntity> listarProfessores();
    ProfessorEntity buscarProfessorPorId(Long id);
    ProfessorEntity atualizarProfessor(Long id, ProfessorEntity professor);
    void excluirProfessor(Long id);

}
