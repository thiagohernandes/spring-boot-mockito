package com.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.rest.filter.CORSFilter;
import com.rest.model.Produto;
import com.rest.repository.ProdutoRepository;
import com.rest.service.ProdutoService;

public class ProdutoControllerMockitoTests {

	private MockMvc mockMvc;
	
	@Mock
	private ProdutoRepository repository;
	
	@Mock
	private ProdutoService service;
	
	@InjectMocks
	private ProdutoController controller;
	
	private String URL_API = "/api-produtos";
	
	private Gson gson;
	
	@Before
	public void init() throws Exception {
		gson = new Gson();
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .addFilters(new CORSFilter())
                .build();
	}
	
	@Test
	public void getAllProdutosTest() throws Exception {
	    mockMvc.perform(get(URL_API))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	    verify(service, times(1)).findAll();
	    verifyNoMoreInteractions(service);
	}
	
	 @Test
	    public void postProdutoTests() throws Exception {
	    	Produto novo = new Produto("Desc", 43, 44.32);
	    	MvcResult result = mockMvc.perform(post(URL_API)
	    			.accept(MediaType.APPLICATION_JSON)
	    			.content(gson.toJson(novo))
	                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
	    	assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	    }
	
}
