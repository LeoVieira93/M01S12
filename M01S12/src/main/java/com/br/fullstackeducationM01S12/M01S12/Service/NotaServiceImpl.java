package com.br.fullstackeducationM01S12.M01S12.Service;

import com.br.fullstackeducationM01S12.M01S12.Entity.NotaEntity;
import com.br.fullstackeducationM01S12.M01S12.Exception.NotFoundException;
import com.br.fullstackeducationM01S12.M01S12.Repository.NotaRepository;
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
public class NotaServiceImpl {

    private final NotaRepository notaRepository;

    public NotaServiceImpl(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @PostMapping
    public NotaEntity criarNota(NotaEntity notaNovo) {
        notaNovo.setId(null);
        NotaEntity nota = notaRepository.save(notaNovo);
        return nota;
    }

    @GetMapping
    public List<NotaEntity> listarNotas() {
        List<NotaEntity> notas = notaRepository.findAll();
        return notas;
    }

    @GetMapping("/{id}")
    public NotaEntity buscarNotaPorId(Long id) {
        Optional<NotaEntity> nota = notaRepository.findById(id);
        if (nota.isEmpty()) {
            return notaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Nota não encontrado com o ID: " + id));
        }
        return nota.get();
    }

    @PutMapping("/{id}")
    public NotaEntity atualizarNota(Long id, NotaEntity nota) {
        if (!notaRepository.existsById(id)) {
            throw new NotFoundException("Nota não encontrado com o ID: " + id);
        }
        nota.setId(id);
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void excluirNota(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new NotFoundException("Nota não encontrada com o ID: " + id);
        }
        notaRepository.deleteById(id);
    }
    
}
