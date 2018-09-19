package br.com.astek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.astek.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{


}
