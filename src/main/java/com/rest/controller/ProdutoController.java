package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.save(produto));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> findById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(produtoService.findById(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<Produto>> findAll() {
		return ResponseEntity.ok(produtoService.findAll());
	}
	
	@GetMapping("/descricao/{descricao}")
	public  ResponseEntity<List<Produto>> findByDescricao(@PathVariable("descricao") String descricao) {
		return ResponseEntity.ok(produtoService.consultaDescricao(descricao));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		produtoService.deleteById(id);
	}

}
