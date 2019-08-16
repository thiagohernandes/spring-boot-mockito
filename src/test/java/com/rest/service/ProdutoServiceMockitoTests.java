package com.rest.service;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rest.model.Produto;
import com.rest.repository.ProdutoRepository;

public class ProdutoServiceMockitoTests {

	@Mock
	private ProdutoRepository repository;
	
	@InjectMocks
	private ProdutoService service;
	
	@Before
	public void init() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllProdutosTest() throws Exception {
	    when(service.findAll()).thenReturn(Mockito.<Produto>anyList());
	}
	
	@Test
    public void postProdutoTests() {
		
	}
}
