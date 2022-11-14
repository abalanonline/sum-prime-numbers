package com.example;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class PrimeNumbersService {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(PrimeNumbersService.class);
  public static final int MAX_TILL = 10_000_000;
  public static final String PRIMES_RESOURCE = "/primes.txt";

  private final int[] primes;

  public PrimeNumbersService() {
    InputStream inputStream = getClass().getResourceAsStream(PRIMES_RESOURCE);
    if (inputStream == null) {
      // do not fail, calculate primes
      log.warn("Calculating primes, please wait 5 min");
      this.primes = getPrimes(MAX_TILL);
      log.warn("Calculation complete, starting service");
    } else {
      // happy path, just load the table
      Scanner scanner = new Scanner(inputStream);
      List<Integer> primes = new ArrayList<>();
      while (scanner.hasNextInt()) {
        primes.add(scanner.nextInt());
      }
      this.primes = primes.stream().mapToInt(i -> i).toArray();
    }
  }

  /**
   * Calculate a sum of prime numbers in a range.
   * @param from the beginning number, inclusive
   * @param till the ending number, exclusive
   * @return sum of prime numbers
   * @throws IllegalArgumentException if the arguments are out of the 0-10_000_000 range or in wrong order
   */
  public BigInteger sumPrimes(int from, int till) throws IllegalArgumentException {
    if (from < 0) throw new IllegalArgumentException(String.format("Starting number %d is less than zero", from));
    if (till > MAX_TILL) throw new IllegalArgumentException(
        String.format("Ending number %d is greater than maximum allowed %d", from, MAX_TILL));
    if (from > till) throw new IllegalArgumentException(
        String.format("Starting number %d is greater than ending number %d", from, till));
    BigInteger result = BigInteger.ZERO;
    for (int prime : primes) {
      if (prime >= till) break;
      if (prime >= from) result = result.add(BigInteger.valueOf(prime));
    }
    return result;
  }

  protected static int[] getPrimes(int till) {
    int[] primes = new int[1_000_000];
    primes[0] = 2;
    int primesLength = 1;
    nLoop:
    for (int n = 3; n < till; n += 2) {
      for (int i = 0; i < primesLength; i++) {
        if (n % primes[i] == 0) continue nLoop;
      }
      primes[primesLength++] = n;
    }
    return Arrays.copyOf(primes, primesLength);
  }

}
