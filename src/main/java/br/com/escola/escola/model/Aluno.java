package br.com.escola.escola.model;

import br.com.escola.escola.dto.request.DadosAtualizacaoAluno;
import br.com.escola.escola.dto.request.DadosCadastroAluno;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String senha;
    @Embedded
    private Email email;
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();
    private boolean ativo;

    public Aluno(DadosCadastroAluno dados, String senhaCifrada) {
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = new Email(dados.email());
        this.senha = senhaCifrada;
        this.telefones.add(new Telefone(dados.telefone()));
        this.ativo = true;
    }

    public void atualizarDados(DadosAtualizacaoAluno dados) {
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        this.email.atualizarDados(dados.email());
    }

    public void desativar() {
        this.ativo = false;
    }

    public void atualizarSenha(String senhaCifradaAtualizada) {
        this.senha = senhaCifradaAtualizada;
    }
}
