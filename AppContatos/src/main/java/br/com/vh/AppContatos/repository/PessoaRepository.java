package br.com.vh.AppContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vh.AppContatos.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
