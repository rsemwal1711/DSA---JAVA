package GREEDY_ALGOS;

import java.util.*;

public class _14InsertInteraval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            ans.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while(i < n){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] interval = {{1,2},{3,4},{5,7},{8,10},{12,16}};
        int[] newInterval = {6,8};
        int[][] ans = insert(interval, newInterval);
        for (int i=0;i<interval.length;i++) {
            System.out.print("[");
            for (int j = 0; j < 2; j++) {
                if(j == 0) System.out.print(interval[i][j] + ",");
                else System.out.print(interval[i][j]);
            }
            if(i!=interval.length-1) System.out.print("],");
            else System.out.print("]");
        }
    }
}