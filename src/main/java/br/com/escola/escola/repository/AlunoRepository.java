package br.com.escola.escola.repository;

import br.com.escola.escola.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Page<Aluno> findAllByAtivoTrue(Pageable pageable);

}
