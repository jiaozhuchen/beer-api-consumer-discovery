package com.example.cc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;

@RestController
public class ProductController {

	@Autowired
	private RestTemplate restTemplate;

//
//	public ProductController(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}


	@RequestMapping(method = RequestMethod.POST,
			value = "/updatePrice",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product updatePrice(@RequestBody ProductPriceRequest request) throws MalformedURLException {
		//remove::start[]
		//tag::controller[]
		ResponseEntity<Product> response = this.restTemplate.exchange(
				RequestEntity
						.post(URI.create("http://somenameforproducer/updatePrice"))
						.contentType(MediaType.APPLICATION_JSON)
						.body(request),
				Product.class);
		return response.getBody();
		//end::controller[]
		//remove::end[return]
	}
}
