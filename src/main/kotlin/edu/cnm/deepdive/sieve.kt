package edu.cnm.deepdive

import kotlin.math.sqrt

fun sieve(limit: Int): List<Int> {
    val primes = mutableListOf<Int>()
    if (limit >= 2) {
        val flags = Array(2) { false } + Array(limit - 1) { true }
        for (value in 2..sqrt(limit.toDouble()).toInt()) {
            if (flags[value]) {
                for (multiple in (value * value)..limit step value) {
                    flags[multiple] = false
                }
            }
        }
        flags.forEachIndexed { index, flag ->
            if (flag) {
                primes.add(index);
            }
        }
    }
    return primes
}

fun main(args: Array<String>) {
    val upperBound = 100;
    val primes = sieve(upperBound)
    println("${primes.size} primes from 1 and $upperBound: $primes")
}