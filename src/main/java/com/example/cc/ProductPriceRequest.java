package com.example.cc;

import java.math.BigDecimal;

public class ProductPriceRequest {
	private Long productId;

	private BigDecimal price;

	public ProductPriceRequest(Long productId, BigDecimal price) {
		this.productId = productId;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
