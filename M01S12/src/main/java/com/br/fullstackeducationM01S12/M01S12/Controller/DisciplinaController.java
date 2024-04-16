package com.br.fullstackeducationM01S12.M01S12.Controller;

import com.br.fullstackeducationM01S12.M01S12.Entity.DisciplinaEntity;
import com.br.fullstackeducationM01S12.M01S12.Service.DisciplinaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaServiceImpl disciplinaServiceImpl;

    @PostMapping
    public ResponseEntity<DisciplinaEntity> criarDisciplina(@RequestBody DisciplinaEntity disciplina) {
        log.info("POST /Disciplinas -> Cadastrado");
        log.info("POST /Disciplinas -> 201 CREATED");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(disciplinaServiceImpl.criarDisciplina(disciplina));
    }
    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> listarDisciplinas() {
        log.info("GET/Disciplinas -> 200 OK");
        return ResponseEntity.ok(disciplinaServiceImpl.listarDisciplinas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> buscarDisciplinaPorId(@PathVariable Long id) {
        log.info("GET /Disciplinas/{} -> 200 OK", id);
        return ResponseEntity.ok(disciplinaServiceImpl.buscarDisciplinaPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> atualizarDisciplina(@PathVariable Long id, @RequestBody DisciplinaEntity disciplina) {
        log.info("PUT /Disciplinas/{} -> 200 OK", id);
        return ResponseEntity.ok(disciplinaServiceImpl.atualizarDisciplina(id, disciplina));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDisciplina(@PathVariable Long id) {
        log.info("DELETE /Disciplinas/{} -> 204 NO CONTENT", id);
        disciplinaServiceImpl.excluirDisciplina(id);
        return ResponseEntity.noContent().build();
    }
    
}
