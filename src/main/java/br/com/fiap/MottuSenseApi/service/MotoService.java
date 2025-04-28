package br.com.fiap.MottuSenseApi.service;
import br.com.fiap.MottuSenseApi.dto.MotoDto;
import br.com.fiap.MottuSenseApi.model.Cliente;
import br.com.fiap.MottuSenseApi.model.Moto;
import br.com.fiap.MottuSenseApi.repository.ClienteRepository;
import br.com.fiap.MottuSenseApi.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    public Page<MotoDto> findAll(Pageable pageable) {
        return motoRepository.findAll(pageable)
                .map(moto -> new MotoDto(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getModelo(),
                        moto.getNumeroChassi(),
                        moto.getStatus(),
                        moto.getCliente().getId()));
    }

    public MotoDto findById(Long id) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        return new MotoDto(moto.getId(), moto.getPlaca(), moto.getModelo(), moto.getNumeroChassi(), moto.getStatus(), moto.getCliente().getId());
    }

    public MotoDto save(MotoDto dto) {
        Moto moto = new Moto();
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setNumeroChassi(dto.getNumeroChassi());
        moto.setStatus(dto.getStatus());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        moto.setCliente(cliente);

        moto = motoRepository.save(moto);
        return new MotoDto(moto.getId(), moto.getPlaca(), moto.getModelo(), moto.getNumeroChassi(), moto.getStatus(), moto.getCliente().getId());
    }

    public MotoDto update(Long id, MotoDto dto) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));

        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setNumeroChassi(dto.getNumeroChassi());
        moto.setStatus(dto.getStatus());

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        moto.setCliente(cliente);

        moto = motoRepository.save(moto);
        return new MotoDto(moto.getId(), moto.getPlaca(), moto.getModelo(), moto.getNumeroChassi(), moto.getStatus(), moto.getCliente().getId());
    }

    public void delete(Long id) {
        motoRepository.deleteById(id);
    }

    public Page<MotoDto> searchByParams(String placa, String modelo, Pageable pageable) {
        return motoRepository.searchByParams(placa, modelo, pageable)
                .map(moto -> new MotoDto(
                        moto.getId(),
                        moto.getPlaca(),
                        moto.getModelo(),
                        moto.getNumeroChassi(),
                        moto.getStatus(),
                        moto.getCliente().getId()));
    }
}