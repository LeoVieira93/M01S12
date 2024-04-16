package com.br.fullstackeducationM01S12.M01S12.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "notas")
public class NotaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_matricula_id", nullable = false)
    private MatriculaEntity disciplinaMatriculaId;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntity professorId;

    @JoinColumn(name = "data_matricula", nullable = false)
    private float nota;

    @ColumnDefault(value = "0.00")
    @Column(precision = 19,scale = 6, nullable = false)
    private BigDecimal coeficiente;

}
