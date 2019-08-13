package com.rest.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rest.filter.CORSFilter;
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
}
