package com.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Produto;
import com.rest.service.ProdutoService;

@RestController
@RequestMapping("/api-produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public Produto save(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	@PutMapping
	public Produto update(@RequestBody Produto produto) {
		return produtoService.save(produto);
	}
	
	@GetMapping("/id/{id}")
	public Produto findById(@PathVariable("id") Integer id) {
		return produtoService.findById(id);
	}
	
	@GetMapping()
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	
	@GetMapping("/descricao/{descricao}")
	public List<Produto> findAllByDescricao(@PathVariable("descricao") String descricao) {
		return produtoService.consultaDescricao(descricao);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		produtoService.deleteById(id);
	}

}
