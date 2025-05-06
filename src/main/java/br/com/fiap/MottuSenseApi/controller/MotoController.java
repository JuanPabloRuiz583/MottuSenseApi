package br.com.fiap.MottuSenseApi.controller;

import br.com.fiap.MottuSenseApi.dto.MotoDto;
import br.com.fiap.MottuSenseApi.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService motoService;



    @GetMapping
    public ResponseEntity<List<MotoDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(motoService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(motoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MotoDto> save(@Valid @RequestBody MotoDto dto) {
        return ResponseEntity.ok(motoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDto> update(@PathVariable Long id, @Valid @RequestBody MotoDto dto) {
        return ResponseEntity.ok(motoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        motoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<MotoDto>> searchByParams(
            @RequestParam(required = false) String placa,
            @RequestParam(required = false) String modelo) {
        return ResponseEntity.ok(motoService.searchByParams(placa, modelo));
    }
}