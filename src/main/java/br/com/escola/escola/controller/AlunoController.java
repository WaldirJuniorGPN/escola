package br.com.escola.escola.controller;

import br.com.escola.escola.dto.request.DadosAtualizacaoAluno;
import br.com.escola.escola.dto.request.DadosCadastroAluno;
import br.com.escola.escola.dto.response.DadosDetalhamentoAluno;
import br.com.escola.escola.dto.response.DadosListagemAluno;
import br.com.escola.escola.model.Aluno;
import br.com.escola.escola.repository.AlunoRepository;
import br.com.escola.escola.service.CifradorDesenhaBcryptServerce;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CifradorDesenhaBcryptServerce cifrador;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriComponentsBuilder) {
        var senhaCifrada = cifrador.cifrarSenha(dados.senha());
        var aluno = new Aluno(dados, senhaCifrada);
        var uri = uriComponentsBuilder.path("usuario/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listar(Pageable paginacao) {
        var page = this.alunoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados) {
        var aluno = this.alunoRepository.getReferenceById(dados.id());

        if (dados.senha() != null) {
         var senhaCifradaAtualizada = this.cifrador.cifrarSenha(dados.senha());
         aluno.atualizarSenha(senhaCifradaAtualizada);
        }

        aluno.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("usuario/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var aluno = this.alunoRepository.getReferenceById(id);
        aluno.desativar();
        return ResponseEntity.noContent().build();
    }

}
