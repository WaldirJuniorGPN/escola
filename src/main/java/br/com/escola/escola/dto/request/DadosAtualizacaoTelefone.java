package br.com.escola.escola.dto.request;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoTelefone(
        @Pattern(regexp = "^[0-9]{2}$", message = "O DDD deve conter exatamente dois dígitos numéricos.")
        String ddd,
        @Pattern(regexp = "^[0-9]{8,9}$", message = "O telefone deve conter de 8 a 9 dígitos numéricos.")
        String telefone
) {
}
