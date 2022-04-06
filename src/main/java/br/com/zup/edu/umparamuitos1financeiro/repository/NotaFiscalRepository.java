package br.com.zup.edu.umparamuitos1financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos1financeiro.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{

}
