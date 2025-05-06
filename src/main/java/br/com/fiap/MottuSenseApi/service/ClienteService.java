package br.com.fiap.MottuSenseApi.service;
import br.com.fiap.MottuSenseApi.dto.ClienteDto;
import br.com.fiap.MottuSenseApi.model.Cliente;
import br.com.fiap.MottuSenseApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Cacheable("clientes")
    public List<ClienteDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clienteRepository.findAll(pageable)
                .stream()
                .map(cliente -> new ClienteDto(
                        cliente.getId(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getSenha()))
                .toList();
    }

    @Cacheable(value = "clientes", key = "#id")
    public ClienteDto findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @CacheEvict(value = "clientes", allEntries = true)
    public ClienteDto save(ClienteDto dto) {
        if (clienteRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Cliente com o e-mail " + dto.getEmail() + " já existe.");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());

        cliente = clienteRepository.save(cliente);
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @CacheEvict(value = "clientes", allEntries = true)
    public ClienteDto update(Long id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (!cliente.getEmail().equals(dto.getEmail()) &&
                clienteRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Cliente com o e-mail " + dto.getEmail() + " já existe.");
        }

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());

        cliente = clienteRepository.save(cliente);
        return new ClienteDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getSenha());
    }

    @CacheEvict(value = "clientes", allEntries = true)
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}