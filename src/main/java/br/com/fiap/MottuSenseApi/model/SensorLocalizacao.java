package br.com.fiap.MottuSenseApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SensorLocalizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Latitude não pode ser nula")
    private double latitude;

    @NotNull(message = "Longitude não pode ser nula")
    private double longitude;

    @NotNull(message = "Data e hora da localização não podem ser nulas")
    private LocalDateTime timeDaLocalizacao;

    @ManyToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;
}