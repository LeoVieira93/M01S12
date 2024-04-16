package com.br.fullstackeducationM01S12.M01S12.Controller;

import com.br.fullstackeducationM01S12.M01S12.Entity.NotaEntity;
import com.br.fullstackeducationM01S12.M01S12.Service.NotaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notas")
@RequiredArgsConstructor
public class NotaController {
    
    private final NotaServiceImpl notaServiceImpl;

    @PostMapping
    public ResponseEntity<NotaEntity> criarNota(@RequestBody NotaEntity nota) {
        log.info("POST /Notas -> Cadastrado");
        log.info("POST /Notas -> 201 CREATED");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(notaServiceImpl.criarNota(nota));
    }
    @GetMapping
    public ResponseEntity<List<NotaEntity>> listarNotas() {
        log.info("GET/Notas -> 200 OK");
        return ResponseEntity.ok(notaServiceImpl.listarNotas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<NotaEntity> buscarNotaPorId(@PathVariable Long id) {
        log.info("GET /Notas/{} -> 200 OK", id);
        return ResponseEntity.ok(notaServiceImpl.buscarNotaPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<NotaEntity> atualizarNota(@PathVariable Long id, @RequestBody NotaEntity nota) {
        log.info("PUT /Notas/{} -> 200 OK", id);
        return ResponseEntity.ok(notaServiceImpl.atualizarNota(id, nota));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNota(@PathVariable Long id) {
        log.info("DELETE /Notas/{} -> 204 NO CONTENT", id);
        notaServiceImpl.excluirNota(id);
        return ResponseEntity.noContent().build();
    }    
}
