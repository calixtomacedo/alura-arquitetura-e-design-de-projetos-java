package br.com.cmdev.bddejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cmdev.bddejava.model.Leilao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long>  {


}
