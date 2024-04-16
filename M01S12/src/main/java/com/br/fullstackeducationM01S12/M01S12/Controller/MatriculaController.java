package com.br.fullstackeducationM01S12.M01S12.Controller;

import com.br.fullstackeducationM01S12.M01S12.Entity.MatriculaEntity;
import com.br.fullstackeducationM01S12.M01S12.Service.MatriculaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaServiceImpl matriculaServiceImpl;

    @PostMapping
    public ResponseEntity<MatriculaEntity> criarMatricula(@RequestBody MatriculaEntity matricula) {
        log.info("POST /Matriculas -> Cadastrado");
        log.info("POST /Matriculas -> 201 CREATED");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(matriculaServiceImpl.criarMatricula(matricula));
    }
    @GetMapping
    public ResponseEntity<List<MatriculaEntity>> listarMatriculas() {
        log.info("GET/Matriculas -> 200 OK");
        return ResponseEntity.ok(matriculaServiceImpl.listarMatriculas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaEntity> buscarMatriculaPorId(@PathVariable Long id) {
        log.info("GET /Matriculas/{} -> 200 OK", id);
        return ResponseEntity.ok(matriculaServiceImpl.buscarMatriculaPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MatriculaEntity> atualizarMatricula(@PathVariable Long id, @RequestBody MatriculaEntity matricula) {
        log.info("PUT /Matriculas/{} -> 200 OK", id);
        return ResponseEntity.ok(matriculaServiceImpl.atualizarMatricula(id, matricula));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMatricula(@PathVariable Long id) {
        log.info("DELETE /Matriculas/{} -> 204 NO CONTENT", id);
        matriculaServiceImpl.excluirMatricula(id);
        return ResponseEntity.noContent().build();
    }
    
}
