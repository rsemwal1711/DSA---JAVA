package BIT_MANUPULATION;

import java.util.*;

public class primeFactors {
    public static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 60;
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if (n % i == 0 && isPrime(i)) {
                ans.add(i);
            }
        }
        System.out.println(ans);

//        or this is also the way to do this question

//            List<Integer> list = new ArrayList<>();
//
//            for (int i = 2; i * i <= N; i++) {
//                if (N % i == 0) {
//                    list.add(i);
//                    while (N % i == 0) {
//                        N = N / i;
//                    }
//                }
//            }
//
//            if (N > 1) {
//                list.add(N);
//            }
//
//            return list;
//        }

    }
}
