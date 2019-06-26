package com.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.model.Produto;
import com.rest.service.ProdutoService;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoControllerTests {
	
    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;
    
    Produto produto = new Produto();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        produto = new Produto(17, "Produto 1", 3, 41.64);
    }
    
    @Test
    public void return_Lista_Produtos_Success() {
        List<Produto> listProdutos = new ArrayList<>();
        Produto prod1 = new Produto(1, "Produto 1", 11, 343.11);
        Produto prod2 = new Produto(2, "Produto 2", 43, 732.49);
        listProdutos.add(prod1);
        listProdutos.add(prod2);
        when(produtoService.findAll()).thenReturn(listProdutos);
        List<Produto> listaProdutosCon = produtoController.findAll();
        assertEquals(2, listaProdutosCon.size());
        verify(produtoService, times(1)).findAll();
    }
    
    @Test
    public void return_Produto_Success_ById(){
        when(produtoService.findById(17)).thenReturn(produto);
        Produto pro = produtoController.findById(17);
        assertEquals("Produto 1", pro.getDescricao());
    }
    
    @Test
    public void create_Produto_Success(){
        produtoController.save(produto);
        verify(produtoService, times(1)).save((produto));
    }
    
    @Test
    public void delete_Produto_Success(){
        produtoController.delete(produto.getId());
        verify(produtoService, times(1)).deleteById(produto.getId());
        assertEquals(null, produtoController.findById(produto.getId()));
        
    }
    
    @Test
    public void update_Produto_Success(){
    	when(produtoService.findById(17)).thenReturn(produto);
        Produto produto = produtoController.findById(17);
    	produto.setDescricao("Nova descrição");
    	produtoController.save(produto);
    	verify(produtoService, times(1)).save(produto);
    }
     
   
}
