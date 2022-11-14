package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersServiceTest {

  @Test
  void sumPrimes() {
    assertEquals(1060, new PrimeNumbersService().sumPrimes(1, 100));
  }
}
