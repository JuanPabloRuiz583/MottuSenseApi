package br.com.fiap.MottuSenseApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Endereço não pode estar em branco")
    @Size(max = 255, message = "Endereço não pode exceder 255 caracteres")
    private String endereco;

    @NotNull(message = "Latitude não pode ser nula")
    private double latitude;

    @NotNull(message = "Longitude não pode ser nula")
    private double longitude;

    @OneToMany(mappedBy = "patio")
    private List<Moto> motos;
}