package edu.cnm.deepdive

static List sieve(Integer limit) { // limit is inclusive
    def flags = [false] * 2 + [true] * (limit - 1)
    (2..(Math.sqrt(limit).intValue())).each {value ->
        if (flags[value]) {
            ((value**2)..limit).step(value) {
                flags[it] = false;
            }
        }
    }
    (0..limit).findAll {
        flags[it]
    }
}

def upperBound = 100
def primes = sieve(upperBound)
println("${primes.size()} primes from 1 to $upperBound: $primes")