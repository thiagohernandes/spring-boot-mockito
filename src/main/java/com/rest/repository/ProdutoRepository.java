package com.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Query(value= 	" SELECT id, descricao, qtd, valor " + 
					" from tbl_produto   " + 
					" where " + 
					"	1 = 1 " + 
					"	and UPPER(descricao) like UPPER(:pDescricao) " +
					" order by " + 
					" descricao ASC ", nativeQuery=true)
	public List<Produto> consultaGenericaDescricao(@Param("pDescricao") String pDescricao);
	
}
