package br.com.fiap.MottuSenseApi.dto;

import br.com.fiap.MottuSenseApi.model.StatusMoto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotoDto {
    private Long id;

    @NotBlank(message = "Placa não pode estar em branco")
    @Size(max = 10, message = "Placa não pode exceder 10 caracteres")
    private String placa;

    @NotBlank(message = "Modelo não pode estar em branco")
    @Size(max = 50, message = "Modelo não pode exceder 50 caracteres")
    private String modelo;

    @NotBlank(message = "Número do Chassi não pode estar em branco")
    @Size(max = 17, message = "Número do Chassi não pode exceder 17 caracteres")
    private String numeroChassi;

    @NotNull(message = "Status não pode ser nulo")
    private StatusMoto status;

    @NotNull(message = "Cliente ID não pode ser nulo")
    private Long clienteId;
}