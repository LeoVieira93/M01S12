package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.DisciplinaEntity;
import com.br.fullstackeducationM01S12.M01S12.Exception.NotFoundException;
import com.br.fullstackeducationM01S12.M01S12.Repository.DisciplinaRepository;
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
public class DisciplinaServiceImpl {

    private final DisciplinaRepository disciplinaRepository;

    @PostMapping
    public DisciplinaEntity criarDisciplina(DisciplinaEntity disciplinaNovo) {
        disciplinaNovo.setId(null);
        DisciplinaEntity disciplina = disciplinaRepository.save(disciplinaNovo);
        return disciplina;
    }

    @GetMapping
    public List<DisciplinaEntity> listarDisciplinas() {
        List<DisciplinaEntity> disciplinas = disciplinaRepository.findAll();
        return disciplinas;
    }

    @GetMapping("/{id}")
    public DisciplinaEntity buscarDisciplinaPorId(Long id) {
        Optional<DisciplinaEntity> disciplina = disciplinaRepository.findById(id);
        if (disciplina.isEmpty()) {
            return disciplinaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Disciplina não encontrado com o ID: " + id));
        }
        return disciplina.get();
    }

    @PutMapping("/{id}")
    public DisciplinaEntity atualizarDisciplina(Long id, DisciplinaEntity disciplina) {
        if (!disciplinaRepository.existsById(id)) {
            throw new NotFoundException("Disciplina não encontrado com o ID: " + id);
        }
        disciplina.setId(id);
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public void excluirDisciplina(Long id) {
        if (!disciplinaRepository.existsById(id)) {
            throw new NotFoundException("Disciplina não encontrada com o ID: " + id);
        }
        disciplinaRepository.deleteById(id);
    }
    
}
