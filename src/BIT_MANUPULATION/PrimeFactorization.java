package BIT_MANUPULATION;

import java.util.*;

public class PrimeFactorization {

    public static void getAnswers(List<Integer> queries){
        for(int i=0;i<queries.size();i++){
            List<Integer> lst = primeFactors(queries.get(i));
            System.out.println(lst);
        }
    }

    public static List<Integer> primeFactors(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                while(n%i == 0){
                    ans.add(i);
                    n/=i;
                }
            }
        }
        if(n > 1){
            ans.add(n);
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        ans.add(12);
        ans.add(16);
        ans.add(60);
        getAnswers(ans);
    }
}