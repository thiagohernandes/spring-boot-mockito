package com.rest.controller;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.rest.model.Produto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoControllerTests {
	
	private String URL_API = "/api-produtos";
	private Gson gson;
	
	@LocalServerPort
	int port;
	
    @Before
    public void setUp() {
        RestAssured.port = port;
        gson = new Gson();
    }

    @Test
    public void getAllProdutosTests() {
    	Response response = get(URL_API);
    	response.then().body("size()", greaterThan(1));
    }
    
    @Test
    public void postProdutoTests() {
    	Produto novo = new Produto("Desc", 43, 44.32);
    	given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(gson.toJson(novo))
		.when().post(URL_API)
	    .then()
	        .statusCode(200)
	        .body("descricao", equalTo("Desc"))
	        .body("id", anything());
    }
    
    @Test
    public void getProdutoIdTests() {
    	Integer id = given().contentType(ContentType.JSON)
    			  	 .when().get(URL_API)
    			  	 .then()
    			  	 	.extract().response().body().path("[0].id");
    	 given().when().get(URL_API.concat("/id/" + id)).
    	 then().body("descricao", Matchers.anything());
    }
    
    @Test
    public void putProdutoTests() {
    	Integer id = given().contentType(ContentType.JSON)
    			  	 .when().get(URL_API)
    			     .then().extract().response().body().path("[0].id");
    	Produto produto = new Produto(id, "Desc alterada", 43, 44.32);
    	Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(gson.toJson(produto))
    			.when()
    			.put(URL_API);
    	response.then().body("id", Matchers.is(id));
    	response.then().body("descricao", Matchers.is("Desc alterada"));
    	response.then().body("qtd", Matchers.is(43));
    	response.then().body("valor", equalTo(44.32f));
    }
    
    @Test
    public void deleteProdutoTests() {
    	Integer id = given().contentType(ContentType.JSON)
    				 .when().get(URL_API)
    				 .then().extract().response().body().path("[0].id");
    	given().when().delete(URL_API.concat("/" + id))
        	   .then().statusCode(200);
    }
    
    @Test
    public void getProdutoByDescricaoTests() {
    	String descricao = given().contentType(ContentType.JSON)
				 .when().get(URL_API)
				 .then().extract().response().body().path("[0].descricao");
    	Response response = get(URL_API.concat("/descricao/" + descricao));
    	response.then().body("size()", greaterThan(0));
    }
  
   
}
