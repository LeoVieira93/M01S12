package com.br.fullstackeducationM01S12.M01S12.Controller;

import com.br.fullstackeducationM01S12.M01S12.Entity.ProfessorEntity;
import com.br.fullstackeducationM01S12.M01S12.Service.ProfessorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorServiceImpl professorServiceImpl;

    @PostMapping
    public ResponseEntity<ProfessorEntity> criarProfessor(@RequestBody ProfessorEntity professor) {
        log.info("POST /Professores -> Cadastrado");
        log.info("POST /Professores -> 201 CREATED");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professorServiceImpl.criarProfessor(professor));
    }
    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> listarProfessores() {
        log.info("GET/Professores -> 200 OK");
        return ResponseEntity.ok(professorServiceImpl.listarProfessores());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> buscarProfessorPorId(@PathVariable Long id) {
        log.info("GET /Professores/{} -> 200 OK", id);
        return ResponseEntity.ok(professorServiceImpl.buscarProfessorPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorEntity> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessorEntity professor) {
        log.info("PUT /Professores/{} -> 200 OK", id);
        return ResponseEntity.ok(professorServiceImpl.atualizarProfessor(id, professor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProfessor(@PathVariable Long id) {
        log.info("DELETE /Professores/{} -> 204 NO CONTENT", id);
        professorServiceImpl.excluirProfessor(id);
        return ResponseEntity.noContent().build();
    }
    
}
