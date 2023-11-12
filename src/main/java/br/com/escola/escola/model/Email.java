package br.com.escola.escola.model;

import br.com.escola.escola.dto.request.DadosAtualizacaoEmail;
import br.com.escola.escola.dto.request.DadosEmail;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class Email {

    private String endereco;

    public Email(DadosEmail dados) {
        this.endereco = dados.email();
    }

    public void atualizarDados(DadosAtualizacaoEmail dados) {
        if (dados != null) {
            this.endereco = dados.endereco();
        }
    }
}
