package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.model.Produto;
import com.rest.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public Produto findById(Integer id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.isPresent() ? new Produto(produto.get().getId(), produto.get().getDescricao(),
				produto.get().getQtd(), produto.get().getValor()) : new Produto();
	}
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Produto> consultaDescricao(String pDescricao){
		return repository.consultaGenericaDescricao("%"+pDescricao+"%");
	}
	
	
}
