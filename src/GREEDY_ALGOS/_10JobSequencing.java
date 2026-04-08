package GREEDY_ALGOS;
import java.util.*;

class _10Job {
    int id;
    int dead;
    int profit;
}

public class _10JobSequencing {
    public static ArrayList<Integer> jobSeq(_10Job[] arr, int n){
        Arrays.sort(arr,(a,b) -> b.profit - a.profit);
        int maxDeadline = arr[0].dead;
        for(int i=1;i<n;i++){
            maxDeadline = Math.max(maxDeadline, arr[i].dead);
        }
        int count = 0;
        int amount = 0;
        int len = maxDeadline;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for(int i=0;i<n;i++){
            int id = arr[i].id;
            for(int j=id-1;j>=0;j--){
                if(ans[j] == -1){
                    ans[j] = id;
                    count++;
                    amount += arr[i].profit;
                    break;
                }
            }
        }
        return new ArrayList<>(Arrays.asList(amount, count));
    }
    public static void main(String[] args) {

        int n = 4;
        _10Job[] arr = new _10Job[] {
                new _10Job() {{id = 1; dead = 4; profit = 20;}},
                new _10Job() {{id = 2; dead = 1; profit = 10;}},
                new _10Job() {{id = 3; dead = 2; profit = 40;}},
                new _10Job() {{id = 4; dead = 2; profit = 30;}}
        };

        ArrayList<Integer> ans = jobSeq(arr, n);

        System.out.println(ans.get(0) + " " + ans.get(1));
    }
}
