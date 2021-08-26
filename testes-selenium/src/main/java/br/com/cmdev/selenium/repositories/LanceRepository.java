package br.com.cmdev.selenium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cmdev.selenium.model.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {

}
