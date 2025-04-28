package br.com.fiap.MottuSenseApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatioDto {
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Endereço não pode estar em branco")
    @Size(max = 200, message = "Endereço não pode exceder 200 caracteres")
    private String endereco;
}