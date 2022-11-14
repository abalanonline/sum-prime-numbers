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
    assertEquals(1060, new PrimeNumbersService().sumPrimes(1, 100).longValue());
  }

  @Test
  void getPrimes() {
    // googled "first 10 prime numbers"
    int[] firstTenPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    assertArrayEquals(firstTenPrimes, PrimeNumbersService.getPrimes(30));
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
