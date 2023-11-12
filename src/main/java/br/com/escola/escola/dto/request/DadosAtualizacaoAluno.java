package br.com.escola.escola.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        String cpf,
        String nome,
        @Valid
        DadosAtualizacaoEmail email,
        @Valid
        DadosAtualizacaoTelefone telefone
) {
}
