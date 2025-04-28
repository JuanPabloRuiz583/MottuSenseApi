package br.com.fiap.MottuSenseApi.controller;

import br.com.fiap.MottuSenseApi.dto.SensorLocalizacaoDto;
import br.com.fiap.MottuSenseApi.service.SensorLocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorLocalizacaoController {

    @Autowired
    private SensorLocalizacaoService sensorLocalizacaoService;

    @GetMapping
    public ResponseEntity<List<SensorLocalizacaoDto>> findAll() {
        return ResponseEntity.ok(sensorLocalizacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorLocalizacaoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(sensorLocalizacaoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SensorLocalizacaoDto> save(@Valid @RequestBody SensorLocalizacaoDto dto) {
        return ResponseEntity.ok(sensorLocalizacaoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorLocalizacaoDto> update(@PathVariable Long id, @Valid @RequestBody SensorLocalizacaoDto dto) {
        return ResponseEntity.ok(sensorLocalizacaoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sensorLocalizacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}