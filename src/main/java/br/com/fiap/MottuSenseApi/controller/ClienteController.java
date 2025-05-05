package br.com.fiap.MottuSenseApi.controller;

import br.com.fiap.MottuSenseApi.dto.ClienteDto;
import br.com.fiap.MottuSenseApi.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

   // @GetMapping
    //public ResponseEntity<List<ClienteDto>> findAll() {
     //   return ResponseEntity.ok(clienteService.findAll());
    //}

    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(clienteService.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteDto> save(@Valid @RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteService.save(dto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> update(@PathVariable Long id, @Valid @RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}