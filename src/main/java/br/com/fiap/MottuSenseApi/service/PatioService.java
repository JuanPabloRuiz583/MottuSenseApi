package br.com.fiap.MottuSenseApi.service;

import br.com.fiap.MottuSenseApi.dto.PatioDto;
import br.com.fiap.MottuSenseApi.model.Patio;
import br.com.fiap.MottuSenseApi.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatioService {

    @Autowired
    private PatioRepository patioRepository;

    public List<PatioDto> findAll() {
        return patioRepository.findAll().stream()
                .map(patio -> new PatioDto(patio.getId(), patio.getNome(), patio.getEndereco()))
                .collect(Collectors.toList());
    }

    public PatioDto findById(Long id) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
        return new PatioDto(patio.getId(), patio.getNome(), patio.getEndereco());
    }

    public PatioDto save(PatioDto dto) {
        Patio patio = new Patio();
        patio.setNome(dto.getNome());
        patio.setEndereco(dto.getEndereco());
        patio = patioRepository.save(patio);
        return new PatioDto(patio.getId(), patio.getNome(), patio.getEndereco());
    }

    public PatioDto update(Long id, PatioDto dto) {
        Patio patio = patioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));

        patio.setNome(dto.getNome());
        patio.setEndereco(dto.getEndereco());

        patio = patioRepository.save(patio);
        return new PatioDto(patio.getId(), patio.getNome(), patio.getEndereco());
    }

    public void delete(Long id) {
        patioRepository.deleteById(id);
    }
}