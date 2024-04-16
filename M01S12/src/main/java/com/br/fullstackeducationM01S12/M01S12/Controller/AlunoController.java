package com.br.fullstackeducationM01S12.M01S12.Controller;

import com.br.fullstackeducationM01S12.M01S12.Entity.AlunoEntity;
import com.br.fullstackeducationM01S12.M01S12.Service.AlunoServiceImpl;
import com.br.fullstackeducationM01S12.M01S12.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoServiceImpl alunoServiceImpl;

    @PostMapping
    public ResponseEntity<AlunoEntity> criarAluno(@RequestBody AlunoEntity aluno) {
        log.info("POST /Alunos -> Cadastrado");
        log.info("POST /Alunos -> 201 CREATED");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(alunoServiceImpl.criarAluno(aluno));
    }
    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        log.info("GET/Alunos -> 200 OK");
        return ResponseEntity.ok(alunoServiceImpl.listarAlunos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> buscarAlunoPorId(@PathVariable Long id) {
        log.info("GET /Alunos/{} -> 200 OK", id);
        return ResponseEntity.ok(alunoServiceImpl.buscarAlunoPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        log.info("PUT /Alunos/{} -> 200 OK", id);
        return ResponseEntity.ok(alunoServiceImpl.atualizarAluno(id, aluno));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAluno(@PathVariable Long id) {
        log.info("DELETE /Alunos/{} -> 204 NO CONTENT", id);
        alunoServiceImpl.excluirAluno(id);
        return ResponseEntity.noContent().build();
    }

}
