package br.com.fiap.MottuSenseApi.config;

import br.com.fiap.MottuSenseApi.model.Moto;
import br.com.fiap.MottuSenseApi.model.StatusMoto;
import br.com.fiap.MottuSenseApi.repository.MotoRepository;
import br.com.fiap.MottuSenseApi.service.MotoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private MotoService motoService;

    @PostConstruct
    public void init() {
        var motos = List.of(
                Moto.builder()
                        .placa("ABC1234")
                        .modelo("Honda CG 160")
                        .numeroChassi("9C2KC0810RDR12345")
                        .status(StatusMoto.DISPONIVEL)
                        .build(),
                Moto.builder()
                        .placa("XYZ5678")
                        .modelo("Yamaha Fazer 250")
                        .numeroChassi("9C2KC0810RDR67890")
                        .status(StatusMoto.EM_MANUTENCAO)
                        .build()
        );


        motoRepository.saveAll(motos);

    }
}