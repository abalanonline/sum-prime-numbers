package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeNumbersController {

	@GetMapping("/sum-primes/till/1000")
	public int getSumTill() {
		return 1060;
	}
}
