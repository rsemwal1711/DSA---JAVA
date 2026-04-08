package GREEDY_ALGOS;

import java.util.*;

public class _3MinNumberOfCoins {
    public static void minNoOfCoins(int n){
        int[] coins = {1,2,5,10,20,50,100,500,1000};
        int count = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=coins.length-1;i>=0;i--){
            while(n >= coins[i]){
                n -= coins[i];
                ans.add(coins[i]);
                count++;
            }
        }
        System.out.print("[");
        for(int i=ans.size()-1;i>=0;i--){
            if(i == 0) System.out.print(ans.get(i));
            else System.out.print(ans.get(i) + ", ");
        }
        System.out.print("]");
        System.out.println(" and count = " + count);

//        return count;
    }
    public static void main(String[] args) {
//        System.out.println(minNoOfCoins(49));
        minNoOfCoins(49);
    }
}
