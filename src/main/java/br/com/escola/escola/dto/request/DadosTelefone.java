package br.com.escola.escola.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosTelefone(
        @NotBlank
        @Pattern(regexp = "^[0-9]{2}$", message = "O DDD deve conter exatamente dois dígitos numéricos.")
        String ddd,
        @NotBlank
        @Pattern(regexp = "^[0-9]{8,9}$", message = "O telefone deve conter de 8 a 9 dígitos numéricos.")
        String telefone
) {
}
