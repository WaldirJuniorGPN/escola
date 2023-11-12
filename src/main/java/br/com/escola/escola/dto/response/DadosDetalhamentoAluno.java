package br.com.escola.escola.dto.response;

import br.com.escola.escola.model.Aluno;

public record DadosDetalhamentoAluno(Long id, String cpf, String nome, String email) {
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getCpf(), aluno.getNome(), aluno.getEmail().getEndereco());
    }
}
