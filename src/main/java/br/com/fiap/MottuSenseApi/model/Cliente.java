package br.com.fiap.MottuSenseApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode estar em branco")
    @Size(max = 100, message = "Nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Email não pode estar em branco")
    @Email(message = "Email deve ser válido")
    @Size(max = 100, message = "Email não pode exceder 100 caracteres")
    private String email;

    @NotBlank(message = "Senha não pode estar em branco")
    @Size(min = 8, max = 20, message = "Senha deve ter entre 8 e 20 caracteres")
    private String senha;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Moto> motos;
}