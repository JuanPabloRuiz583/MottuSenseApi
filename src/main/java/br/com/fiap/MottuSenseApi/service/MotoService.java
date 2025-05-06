package br.com.fiap.MottuSenseApi.service;
import br.com.fiap.MottuSenseApi.dto.MotoDto;
import br.com.fiap.MottuSenseApi.model.Cliente;
import br.com.fiap.MottuSenseApi.model.Moto;
import br.com.fiap.MottuSenseApi.model.Patio;
import br.com.fiap.MottuSenseApi.repository.ClienteRepository;
import br.com.fiap.MottuSenseApi.repository.MotoRepository;
import br.com.fiap.MottuSenseApi.repository.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PatioRepository patioRepository;

    @Cacheable("motos")
    public List<MotoDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return motoRepository.findAll(pageable)
                .stream()
                .map(moto -> new MotoDto(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getModelo(),
                        moto.getNumeroChassi(),
                        moto.getStatus(),
                        moto.getCliente().getId(),
                        moto.getPatio().getId()))
                .toList();
    }

    @Cacheable(value = "motos", key = "#id")
    public MotoDto findById(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        return new MotoDto(
                moto.getId(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getNumeroChassi(),
                moto.getStatus(),
                moto.getCliente().getId(),
                moto.getPatio().getId());
    }

    @CacheEvict(value = "motos", allEntries = true)
    public MotoDto save(MotoDto dto) {
        if (motoRepository.existsByNumeroChassi(dto.getNumeroChassi())) {
            throw new IllegalArgumentException("Moto com o número de chassi " + dto.getNumeroChassi() + " já existe.");
        }

        Moto moto = new Moto();
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setNumeroChassi(dto.getNumeroChassi());
        moto.setStatus(dto.getStatus());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        moto.setCliente(cliente);

        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
        moto.setPatio(patio);

        moto = motoRepository.save(moto);
        return new MotoDto(
                moto.getId(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getNumeroChassi(),
                moto.getStatus(),
                moto.getCliente().getId(),
                moto.getPatio().getId());
    }

    @CacheEvict(value = "motos", allEntries = true)
    public MotoDto update(Long id, MotoDto dto) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));

        // Validate if a motorcycle with the same chassis number already exists (excluding the current one)
        if (!moto.getNumeroChassi().equals(dto.getNumeroChassi()) &&
                motoRepository.existsByNumeroChassi(dto.getNumeroChassi())) {
            throw new IllegalArgumentException("Moto com o número de chassi " + dto.getNumeroChassi() + " já existe.");
        }

        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setNumeroChassi(dto.getNumeroChassi());
        moto.setStatus(dto.getStatus());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        moto.setCliente(cliente);

        Patio patio = patioRepository.findById(dto.getPatioId())
                .orElseThrow(() -> new RuntimeException("Pátio não encontrado"));
        moto.setPatio(patio);

        moto = motoRepository.save(moto);
        return new MotoDto(
                moto.getId(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getNumeroChassi(),
                moto.getStatus(),
                moto.getCliente().getId(),
                moto.getPatio().getId());
    }

    @CacheEvict(value = "motos", allEntries = true)
    public void delete(Long id) {
        motoRepository.deleteById(id);
    }

    public List<MotoDto> searchByParams(String placa, String modelo) {
        List<Moto> motos = motoRepository.searchByParams(placa, modelo);
        return motos.stream()
                .map(moto -> new MotoDto(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getModelo(),
                        moto.getNumeroChassi(),
                        moto.getStatus(),
                        moto.getCliente().getId(),
                        moto.getPatio().getId()))
                .toList();
    }
}