package br.com.escola.escola.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(
        @NotBlank
        @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "O CPF deve estar no formato XXX.XXX.XXX-XX.")
        String cpf,
        @NotBlank
        String nome,
        @Valid
        DadosEmail email,
        @Valid DadosTelefone telefone
) {
}
