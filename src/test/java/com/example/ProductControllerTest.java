package com.example;

import com.example.cc.ProductController;
import com.example.cc.ProductPriceRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
//remove::start[]
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.REMOTE, ids = "test-stubs:producer:master:stubs")
//remove::end[]
@DirtiesContext
public class ProductControllerTest{

	@Autowired MockMvc mockMvc;
	@Autowired ProductController productController;

	@Test public void should_update_price() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
    this.mockMvc
        .perform(
            MockMvcRequestBuilders.post("/updatePrice")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(
                        new ProductPriceRequest(1L, BigDecimal.valueOf(3.5)))))
        .andExpect(status().isOk())
        .andExpect(content().string("{\"id\":1,\"name\":null,\"price\":3.5}"));
	}
}
