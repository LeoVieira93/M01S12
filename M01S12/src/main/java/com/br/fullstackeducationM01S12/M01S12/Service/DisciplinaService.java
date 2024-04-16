package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.DisciplinaEntity;

import java.util.List;

public interface DisciplinaService {

    public DisciplinaEntity criarDisciplina(DisciplinaEntity disciplina);
    public List<DisciplinaEntity> listarDisciplinas();
    public DisciplinaEntity buscarDisciplinaPorId(Long id);
    public DisciplinaEntity atualizarDisciplina(Long id, DisciplinaEntity disciplina);
    public void excluirDisciplina(Long id);

}
