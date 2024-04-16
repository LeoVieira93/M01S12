package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.ProfessorEntity;
import com.br.fullstackeducationM01S12.M01S12.Exception.NotFoundException;
import com.br.fullstackeducationM01S12.M01S12.Repository.ProfessorRepository;
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
public class ProfessorServiceImpl {

    private final ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity criarProfessor(ProfessorEntity professorNovo) {
        professorNovo.setId(null);
        ProfessorEntity professor = professorRepository.save(professorNovo);
        return professor;
    }

    @GetMapping
    public List<ProfessorEntity> listarProfessores() {
        List<ProfessorEntity> professors = professorRepository.findAll();
        return professors;
    }

    @GetMapping("/{id}")
    public ProfessorEntity buscarProfessorPorId(Long id) {
        Optional<ProfessorEntity> professor = professorRepository.findById(id);
        if (professor.isEmpty()) {
            return professorRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Professor não encontrado com o ID: " + id));
        }
        return professor.get();
    }

    @PutMapping("/{id}")
    public ProfessorEntity atualizarProfessor(Long id, ProfessorEntity professor) {
        if (!professorRepository.existsById(id)) {
            throw new NotFoundException("Professor não encontrado com o ID: " + id);
        }
        professor.setId(id);
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void excluirProfessor(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new NotFoundException("Professor não encontrada com o ID: " + id);
        }
        professorRepository.deleteById(id);
    }
    
}
