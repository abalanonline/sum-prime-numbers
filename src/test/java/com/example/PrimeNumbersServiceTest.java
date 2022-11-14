package com.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

class PrimeNumbersServiceTest {

  @Test
  void sumPrimes() {
    PrimeNumbersService service = new PrimeNumbersService();

    assertEquals(1060, service.sumPrimes(1, 100).longValue());
    assertEquals(0, service.sumPrimes(24, 29).longValue()); // no primes in range

    assertThrows(IllegalArgumentException.class, () -> service.sumPrimes(100, 10)); // wrong order
    assertThrows(IllegalArgumentException.class, () -> service.sumPrimes(-10, 10)); // negative
    assertThrows(IllegalArgumentException.class, () -> service.sumPrimes(0, Integer.MAX_VALUE)); // beyond limit
  }

  @Test
  void getPrimes() {
    int[] firstTenPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; // googled "first 10 prime numbers"
    assertArrayEquals(firstTenPrimes, PrimeNumbersService.getPrimes(30));

    int[] primeNumbersFromOneToHundred =
        {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    assertArrayEquals(primeNumbersFromOneToHundred, PrimeNumbersService.getPrimes(100));
  }

  @Disabled
  @Test
  void generatePreCalculatedPrimes() throws IOException {
    // will put the code in disabled test so it will not be included in production jar
    int[] primes = PrimeNumbersService.getPrimes(PrimeNumbersService.MAX_TILL);
    try (PrintWriter printWriter = new PrintWriter(
        Files.newOutputStream(Paths.get("src/main/resources", PrimeNumbersService.PRIMES_RESOURCE)))) {
      Arrays.stream(primes).forEach(printWriter::println);
    }
  }
}
