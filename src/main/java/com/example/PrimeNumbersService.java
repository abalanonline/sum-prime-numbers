package com.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeNumbersService {

  public int sumPrimes(int from, int till) {
    int result = 0;
    for (int prime : getPrimes(till)) {
      if (prime >= from) result += prime;
    }
    return result;
  }

  public int[] getPrimes(int till) {
    // no optimization at this moment, just the first idea that came to my mind
    List<Integer> list = new ArrayList<>();
    nLoop:
    for (int n = 2; n < till; n++) {
      for (int i : list) {
        if (n % i == 0) {
          continue nLoop;
        }
      }
      list.add(n);
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

}
