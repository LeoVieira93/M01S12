package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.NotaEntity;

import java.util.List;

public interface NotaService {

    NotaEntity criarNota(NotaEntity nota);

    List<NotaEntity> listarNotas();

    NotaEntity buscarNotaPorId(Long id);

    NotaEntity atualizarNota(Long id, NotaEntity nota);

    void excluirNota(Long id);

}
