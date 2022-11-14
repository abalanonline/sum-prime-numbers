package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/sum-primes")
public class PrimeNumbersController {

	@Autowired
	private PrimeNumbersService service;

	@GetMapping("/till/{till}")
	public BigInteger getSumTill(@PathVariable("till") int till) {
		return service.sumPrimes(1, till);
	}

	@GetMapping("/from/{from}/till/{till}")
	public BigInteger getSumFromTill(@PathVariable("from") int from, @PathVariable("till") int till) {
		return service.sumPrimes(from, till);
	}
}
