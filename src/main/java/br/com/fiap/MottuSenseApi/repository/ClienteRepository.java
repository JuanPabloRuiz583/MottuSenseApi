package br.com.fiap.MottuSenseApi.repository;

import br.com.fiap.MottuSenseApi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
