package br.com.fiap.MottuSenseApi.controller;
import br.com.fiap.MottuSenseApi.dto.PatioDto;
import br.com.fiap.MottuSenseApi.service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    private PatioService patioService;

    @GetMapping
    public ResponseEntity<List<PatioDto>> findAll() {
        return ResponseEntity.ok(patioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(patioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PatioDto> save(@Valid @RequestBody PatioDto dto) {
        return ResponseEntity.ok(patioService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDto> update(@PathVariable Long id, @Valid @RequestBody PatioDto dto) {
        return ResponseEntity.ok(patioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}