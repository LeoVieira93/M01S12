package com.br.fullstackeducationM01S12.M01S12.Repository;

import com.br.fullstackeducationM01S12.M01S12.Entity.AlunoEntity;
import com.br.fullstackeducationM01S12.M01S12.Entity.MatriculaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {

}
