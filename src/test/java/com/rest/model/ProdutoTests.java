package com.rest.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProdutoTests {

	private Produto produto;
	
	@Before
	public void init() {
		produto = new Produto();
	}
	
	@Test
	public void produtoToStringTest() {
		assertNotNull(produto.toString());
	}
	
	@Test
	public void produtoHashCodeTest() {
		assertNotNull(produto.hashCode());
	}
	
	@Test
	public void produtoEqualsTrueTest() {
		Produto produtoEquals = new Produto();
		assertTrue(produto.equals(produtoEquals) == false);
	}
	
	@Test
	public void produtoEqualsFalseTest() {
		Produto produtoEquals = new Produto(22, "Teste", 1, 44.5);
		assertTrue(produto.equals(produtoEquals) == false);
	}
	
}
