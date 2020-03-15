package com.contracts.base;

//remove::start[]

import com.example.ClientApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClientApplication.class)
@AutoConfigureStubRunner(ids = "test-stubs:producer:master:stubs")
public abstract class ContractBase {

	@Autowired
	private WebApplicationContext webApplicationContext;


	@Before
	public void setup() {
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}
}
