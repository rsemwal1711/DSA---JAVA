package GREEDY_ALGOS;

import java.util.*;

public class _15MergeOverlappingSubInt {
    public static int[][] mergeIntervals_BRUTE(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;
            while(j < n && end >= intervals[j][0]){
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            ans.add(new int[] {start, end});
            i = j;
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public static int[][] mergeIntervals_OPTIMAL(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(end >= intervals[i][0]){

                end = Math.max(end, intervals[i][1]);
            }
            else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[] {start, end});
        return ans.toArray(new int[ans.size()][]);
    }


    public static int[][] mergeIntervals_MY_APPROACH(int[][] intervals){
        int i = 0;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        while(i < n-1 && intervals[i][1] < intervals[i+1][0]){
            list.add(intervals[i]);
            i++;
        }
        int maxi = intervals[i][1];
        int mini = intervals[i][0];
        while(i < n-1 && intervals[i][1] >= intervals[i+1][0]){
            mini = Math.min(mini, intervals[i][0]);
            maxi = Math.max(maxi, intervals[i+1][1]);
            i++;
        }
        list.add(new int[] {mini,maxi});
        i++;
        while(i < n){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{4,7}, {1,4}};
        int[][] intervals = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};
//        int[][] ans = mergeIntervals_MY_APPROACH(intervals);
//        int[][] ans = mergeIntervals_OPTIMAL(intervals);
        int[][] ans = mergeIntervals_BRUTE(intervals);
        for(int i=0;i<ans.length;i++){
            System.out.print("[");
            for(int j=0;j<2;j++){
                if(j == 0) System.out.print(ans[i][j] + ",");
                else System.out.print(ans[i][j]);
            }
            if(i != ans.length-1) System.out.print("], ");
            else System.out.print("]");
        }
    }
}
