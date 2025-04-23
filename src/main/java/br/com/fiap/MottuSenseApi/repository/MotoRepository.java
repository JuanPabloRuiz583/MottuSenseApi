package br.com.fiap.MottuSenseApi.repository;
import br.com.fiap.MottuSenseApi.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<Moto, Long> {
}
