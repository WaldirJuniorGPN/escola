package br.com.escola.escola.model;

import br.com.escola.escola.dto.request.DadosAtualizacaoTelefone;
import br.com.escola.escola.dto.request.DadosTelefone;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Telefone")
@Table(name = "telefones")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ddd;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    public Telefone(DadosTelefone dados) {
        this.ddd = dados.ddd();
        this.telefone = dados.telefone();
    }

    public void atualizarDados(List<Telefone> telefones, DadosAtualizacaoTelefone dados) {
        var telefoneParaAtualizar = telefones.stream()
                .filter(t -> t.equals(dados.telefone()))
                .findFirst()
                .orElse(null);

        if (telefoneParaAtualizar != null) {
            this.telefone = dados.telefone();
        }
    }
}
