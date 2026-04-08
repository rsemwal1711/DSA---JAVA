package BIT_MANUPULATION;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactII {

    private static final int MAX_N = 10000;

    // Precompute smallest prime factor for every number up to MAX_N
    private static int[] sieve() {
        int[] factors = new int[MAX_N + 1];
        for (int i = 2; i <= MAX_N; i++) {
            factors[i] = i;
        }

        for (int i = 2; i * i <= MAX_N; i++) {
            if (factors[i] == i) { // i is prime
                for (int j = i * i; j <= MAX_N; j += i) {
                    if (factors[j] == j) {
                        factors[j] = i; // smallest prime factor
                    }
                }
            }
        }
        return factors;
    }

    // Factorize a single number using the precomputed sieve
    private static List<Integer> factorize(int n, int[] factors) {
        List<Integer> ans = new ArrayList<>();
        while (n != 1) {
            ans.add(factors[n]);
            n /= factors[n];
        }
        return ans;
    }

    // Factorize a list of queries
    public static List<List<Integer>> factorsII(List<Integer> queries) {
        int[] factors = sieve();
        List<List<Integer>> result = new ArrayList<>();
        for (int n : queries) {
            result.add(factorize(n, factors));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> queries = new ArrayList<>();
        queries.add(2);
        queries.add(3);
        queries.add(4);
        queries.add(5);
        queries.add(6);

        System.out.println(factorsII(queries));
    }
}
