package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.MatriculaEntity;
import com.br.fullstackeducationM01S12.M01S12.Exception.NotFoundException;
import com.br.fullstackeducationM01S12.M01S12.Repository.MatriculaRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@NoArgsConstructor(force = true)
public class MatriculaServiceImpl {

    private final MatriculaRepository matriculaRepository;

    @PostMapping
    public MatriculaEntity criarMatricula(MatriculaEntity matriculaNovo) {
        matriculaNovo.setId(null);
        MatriculaEntity matricula = matriculaRepository.save(matriculaNovo);
        return matricula;
    }

    @GetMapping
    public List<MatriculaEntity> listarMatriculas() {
        List<MatriculaEntity> matriculas = matriculaRepository.findAll();
        return matriculas;
    }

    @GetMapping("/{id}")
    public MatriculaEntity buscarMatriculaPorId(Long id) {
        Optional<MatriculaEntity> matricula = matriculaRepository.findById(id);
        if (matricula.isEmpty()) {
            return matriculaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Matricula não encontrado com o ID: " + id));
        }
        return matricula.get();
    }

    @PutMapping("/{id}")
    public MatriculaEntity atualizarMatricula(Long id, MatriculaEntity matricula) {
        if (!matriculaRepository.existsById(id)) {
            throw new NotFoundException("Matricula não encontrado com o ID: " + id);
        }
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }

    @DeleteMapping("/{id}")
    public void excluirMatricula(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new NotFoundException("Matricula não encontrada com o ID: " + id);
        }
        matriculaRepository.deleteById(id);
    }
    
}
