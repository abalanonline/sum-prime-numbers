package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersServiceTest {

  @Test
  void sumPrimes() {
    assertEquals(1060, new PrimeNumbersService().sumPrimes(1, 100));
  }

  @Test
  void getPrimes() {
    // googled "first 10 prime numbers"
    int[] firstTenPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    assertArrayEquals(firstTenPrimes, new PrimeNumbersService().getPrimes(30));
  }
}
