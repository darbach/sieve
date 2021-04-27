package edu.cnm.deepdive;

import java.util.Arrays;
import java.util.BitSet;

public class Sieve {

  /**
   * Find the primes, via Sieve of Eratosthenes.
   *
   * @param limit largest value to evaluate, inclusive
   * @return
   */
  public static int[] sieve(int limit) {
    var flags = new BitSet(limit + 1);
    flags.set(2, limit + 1);
    for (var prime = 2; prime <= Math.sqrt(limit); prime = flags.nextSetBit(prime+ 1)) {
      for (var multiple = prime * prime; multiple <= limit; multiple += prime) {
        flags.clear(multiple);
      }
    }
    return flags
        .stream()
        .toArray();
  }

  public static void main(String[] args) {
    var upperBound = 100;
    var primes = sieve(upperBound);
    System.out.printf("%d primes from 1 to %d: %s%n", primes.length, upperBound, Arrays.toString(primes));
  }
}
