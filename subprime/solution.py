import sys

def generate_primes(limit):
    sieve = [True] * (limit + 1)
    sieve[0] = sieve[1] = False
    primes = []
    for p in range(2, int(limit**0.5) + 1):
        if sieve[p]:
            primes.append(p)
            for i in range(p * p, limit + 1, p):
                sieve[i] = False
    for p in range(int(limit**0.5) + 1, limit + 1):
        if sieve[p]:
            primes.append(p)
    return primes

def count_primes_with_substring(primes, i, j, substring):
    count = 0
    for prime in primes[i-1:j]:
        if substring in str(prime):
            count += 1
    return count

primes_limit = 10000000
all_primes = generate_primes(primes_limit)

for input in sys.stdin.readlines():
    [i, j, sub] = input.strip().split(" ")
    print(i, j, sub)
    total = count_primes_with_substring(all_primes, int(i), int(j), sub)
    print(total)



