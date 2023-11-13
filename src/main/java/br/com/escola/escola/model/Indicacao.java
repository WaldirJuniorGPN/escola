package br.com.escola.escola.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Indicacao {

    private Aluno indicado;
    private Aluno indicante;
    private LocalDate data;
}
