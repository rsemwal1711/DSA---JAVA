package BIT_MANUPULATION;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSET(List<Integer> lst){
        List<List<Integer>> ans = new ArrayList<>();

        int n = lst.size();
        int subset = 1 << n;
        for(int i=0;i<subset;i++){
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<n;j++){
                if( (i & (1 << j)) != 0){
                    res.add(lst.get(j));
                }
            }
            ans.add(res);
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> lst = List.of(1,2,3);
        List<List<Integer>> ans = powerSET(lst);
        System.out.println(ans);
    }
}