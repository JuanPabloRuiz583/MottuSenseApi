package br.com.fiap.MottuSenseApi.service;
import br.com.fiap.MottuSenseApi.dto.ClienteDto;
import br.com.fiap.MottuSenseApi.model.Cliente;
import br.com.fiap.MottuSenseApi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //public List<ClienteDto> findAll() {
      //  return clienteRepository.findAll().stream()
        //        .map(cliente -> new ClienteDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getSenha()))
          //      .collect(Collectors.toList());
    //}

    public List<ClienteDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clienteRepository.findAll(pageable)
                .stream()
                .map(cliente -> new ClienteDto(cliente))
                .toList();
    }

    public ClienteDto findById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return new ClienteDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getSenha());
    }

    public ClienteDto save(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        cliente = clienteRepository.save(cliente);
        return new ClienteDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getSenha());
    }

    public ClienteDto update(Long id, ClienteDto dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());

        cliente = clienteRepository.save(cliente);
        return new ClienteDto(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getSenha());
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}