package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumbersController {

	@Autowired
	private PrimeNumbersService service;

	@GetMapping("/sum-primes/till/100")
	public int getSumTill() {
		return service.sumPrimes(1, 100);
	}
}
