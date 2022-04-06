package br.com.zup.edu.umparamuitos1financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos1financeiro.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
