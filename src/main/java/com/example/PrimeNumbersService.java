package com.example;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Arrays;

@Service
public class PrimeNumbersService {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(PrimeNumbersService.class);
  public static final int MAX_TILL = 1_000_000;

  private final int[] primes;

  public PrimeNumbersService() {
    log.warn("Calculating primes, please wait 5 min");
    this.primes = getPrimes(MAX_TILL);
    log.warn("Calculation complete, starting service");
  }

  public BigInteger sumPrimes(int from, int till) {
    BigInteger result = BigInteger.ZERO;
    for (int prime : primes) {
      if (prime >= till) break;
      if (prime >= from) result = result.add(BigInteger.valueOf(prime));
    }
    return result;
  }

  protected int[] getPrimes(int till) {
    int[] primes = new int[1_000_000];
    primes[0] = 2;
    int primesLength = 1;
    nLoop:
    for (int n = 3; n < till; n += 2) {
      for (int i = 0; i < primesLength; i++) {
        if (n % primes[i] == 0) {
          continue nLoop;
        }
      }
      primes[primesLength++] = n;
    }
    return Arrays.copyOf(primes, primesLength);
  }

}
