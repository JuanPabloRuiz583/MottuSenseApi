package br.com.fiap.MottuSenseApi.service;

import br.com.fiap.MottuSenseApi.dto.SensorLocalizacaoDto;
import br.com.fiap.MottuSenseApi.model.Moto;
import br.com.fiap.MottuSenseApi.model.SensorLocalizacao;
import br.com.fiap.MottuSenseApi.repository.MotoRepository;
import br.com.fiap.MottuSenseApi.repository.SensorLocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorLocalizacaoService {

    @Autowired
    private SensorLocalizacaoRepository sensorLocalizacaoRepository;

    @Autowired
    private MotoRepository motoRepository;

    public List<SensorLocalizacaoDto> findAll() {
        return sensorLocalizacaoRepository.findAll().stream()
                .map(sensor -> new SensorLocalizacaoDto(
                        sensor.getId(),
                        sensor.getLatitude(),
                        sensor.getLongitude(),
                        sensor.getTimeDaLocalizacao(),
                        sensor.getMoto().getId()))
                .collect(Collectors.toList());
    }

    public SensorLocalizacaoDto findById(Long id) {
        SensorLocalizacao sensor = sensorLocalizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor de localização não encontrado"));
        return new SensorLocalizacaoDto(
                sensor.getId(),
                sensor.getLatitude(),
                sensor.getLongitude(),
                sensor.getTimeDaLocalizacao(),
                sensor.getMoto().getId());
    }

    public SensorLocalizacaoDto save(SensorLocalizacaoDto dto) {
        SensorLocalizacao sensor = new SensorLocalizacao();
        sensor.setLatitude(dto.getLatitude());
        sensor.setLongitude(dto.getLongitude());
        sensor.setTimeDaLocalizacao(dto.getTimeDaLocalizacao());

        Moto moto = motoRepository.findById(dto.getMotoId())
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        sensor.setMoto(moto);

        sensor = sensorLocalizacaoRepository.save(sensor);
        return new SensorLocalizacaoDto(
                sensor.getId(),
                sensor.getLatitude(),
                sensor.getLongitude(),
                sensor.getTimeDaLocalizacao(),
                sensor.getMoto().getId());
    }

    public SensorLocalizacaoDto update(Long id, SensorLocalizacaoDto dto) {
        SensorLocalizacao sensor = sensorLocalizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor de localização não encontrado"));

        sensor.setLatitude(dto.getLatitude());
        sensor.setLongitude(dto.getLongitude());
        sensor.setTimeDaLocalizacao(dto.getTimeDaLocalizacao());

        Moto moto = motoRepository.findById(dto.getMotoId())
                .orElseThrow(() -> new RuntimeException("Moto não encontrada"));
        sensor.setMoto(moto);

        sensor = sensorLocalizacaoRepository.save(sensor);
        return new SensorLocalizacaoDto(
                sensor.getId(),
                sensor.getLatitude(),
                sensor.getLongitude(),
                sensor.getTimeDaLocalizacao(),
                sensor.getMoto().getId());
    }

    public void delete(Long id) {
        sensorLocalizacaoRepository.deleteById(id);
    }
}