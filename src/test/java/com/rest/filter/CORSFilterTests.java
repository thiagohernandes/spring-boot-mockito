package com.rest.filter;

import static io.restassured.RestAssured.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CORSFilterTests {

	private String URL_API = "/api-produtos";
	
	@LocalServerPort
	int port;
	
    @Before
    public void setUp() {
        RestAssured.port = port;
    }
    
	@Test
    public void CORSTest() {
		get(URL_API)
			.then()
				.assertThat()
					.headers("Access-Control-Allow-Origin", "*",
							 "Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE",
							 "Access-Control-Allow-Headers", "*",
							 "Access-Control-Max-Age", "3600");
	}
}
