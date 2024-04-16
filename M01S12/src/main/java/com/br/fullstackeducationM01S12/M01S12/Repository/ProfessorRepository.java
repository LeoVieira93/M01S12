package com.br.fullstackeducationM01S12.M01S12.Repository;

import com.br.fullstackeducationM01S12.M01S12.Entity.AlunoEntity;
import com.br.fullstackeducationM01S12.M01S12.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
