package com.example;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.stream.IntStream;

@Service
public class PrimeNumbersService {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(PrimeNumbersService.class);
  public static final int MAX_TILL = 10_000_000;

  private final int[] primes;

  public PrimeNumbersService() {
    this.primes = getPrimes(MAX_TILL); // <100 ms for 10^7
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

  protected static int[] getPrimes(int n) {
    boolean[] notPrime = new boolean[n];
    if (n > 0) notPrime[0] = true;
    if (n > 1) notPrime[1] = true;
    for(int i = 2; i * i < n; i++) {
      if (!notPrime[i]) {
        for(int j = i * i; j < n; j += i){
          notPrime[j] = true;
        }
      }
    }
    return IntStream.range(2, n).filter(i -> !notPrime[i]).toArray();
  }

}
