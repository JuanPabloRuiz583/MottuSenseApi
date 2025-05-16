package br.com.fiap.MottuSenseApi.config;

import br.com.fiap.MottuSenseApi.model.Cliente;
import br.com.fiap.MottuSenseApi.model.Moto;
import br.com.fiap.MottuSenseApi.model.Patio;
import br.com.fiap.MottuSenseApi.model.StatusMoto;
import br.com.fiap.MottuSenseApi.repository.ClienteRepository;
import br.com.fiap.MottuSenseApi.repository.MotoRepository;
import br.com.fiap.MottuSenseApi.repository.PatioRepository;
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
    private ClienteRepository clienteRepository;

    @Autowired
    private PatioRepository patioRepository;

    @Autowired
    private MotoService motoService;

    @PostConstruct
    public void init() {
        // Criando clientes
        var cliente1 = Cliente.builder()
                .nome("João Silva")
                .email("joao.silva@examplo.com")
                .senha("123456789")
                .build();

        var cliente2 = Cliente.builder()
                .nome("Maria Oliveira")
                .email("maria.oliveira@examplo.com")
                .senha("987654321")
                .build();

        clienteRepository.saveAll(List.of(cliente1, cliente2));

        // Criando pátios
        var patio1 = Patio.builder()
                .nome("Pátio Central")
                .endereco("Rua Principal, 123")
                .build();

        var patio2 = Patio.builder()
                .nome("Pátio Norte")
                .endereco("Avenida Secundária, 456")
                .build();

        patioRepository.saveAll(List.of(patio1, patio2));


        // Criando motos e vinculando elas aos clientes e pátios
        var motos = List.of(
                Moto.builder()
                        .placa("ABC1234")
                        .modelo("Honda CG 160")
                        .numeroChassi("9C2KC0810RDR12345")
                        .status(StatusMoto.DISPONIVEL)
                        .cliente(cliente1) // Vincula ao cliente1
                        .patio(patio1) // Vincula ao patio1
                        .build(),
                Moto.builder()
                        .placa("XYZ5678")
                        .modelo("Yamaha Fazer 250")
                        .numeroChassi("9C2KC0810RDR67890")
                        .status(StatusMoto.EM_MANUTENCAO)
                        .cliente(cliente2) // Vincula ao cliente2
                        .patio(patio2) // Vincula ao patio2
                        .build()
        );

        motoRepository.saveAll(motos);

    }
}