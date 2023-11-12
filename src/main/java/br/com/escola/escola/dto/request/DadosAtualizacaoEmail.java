package br.com.escola.escola.dto.request;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoEmail(
        @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Formato de e-mail inválido.")
        String endereco
) {
}
