package cc

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'POST'
		url '/updatePrice'
		body([
				productId : 1,
				price     : 3.5,
		])
		headers {
			header 'Content-Type', 'application/json'
		}
	}
	response {
		status 200
		body([
		     id    : 1,
			 price : 3.5
		])
		headers {
			header(
					'Content-Type', value(consumer('application/json'),producer(regex('application/json.*')))
			)
		}
	}
}
