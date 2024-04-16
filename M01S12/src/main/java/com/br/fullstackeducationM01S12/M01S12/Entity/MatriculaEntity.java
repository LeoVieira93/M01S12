package com.br.fullstackeducationM01S12.M01S12.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "matriculas")
public class MatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity alunoId;

    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaEntity disciplinaId;

    @JoinColumn(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula;
    @JoinColumn(name = "media_final", nullable = false)
    private BigDecimal mediaFinal;

}
