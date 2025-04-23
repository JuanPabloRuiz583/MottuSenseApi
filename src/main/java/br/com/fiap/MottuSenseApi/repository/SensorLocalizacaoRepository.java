package br.com.fiap.MottuSenseApi.repository;

import br.com.fiap.MottuSenseApi.model.SensorLocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorLocalizacaoRepository extends JpaRepository<SensorLocalizacao, Long> {
}