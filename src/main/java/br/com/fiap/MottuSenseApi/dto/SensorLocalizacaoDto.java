package br.com.fiap.MottuSenseApi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorLocalizacaoDto {
    private Long id;

    @NotNull(message = "Latitude não pode ser nula")
    private double latitude;

    @NotNull(message = "Longitude não pode ser nula")
    private double longitude;

    @NotNull(message = "Moto ID não pode ser nulo")
    private Long motoId;
}