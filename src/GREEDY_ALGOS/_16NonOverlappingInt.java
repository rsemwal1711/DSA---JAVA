package GREEDY_ALGOS;
import java.util.*;

public class _16NonOverlappingInt {
    public static int nonOverlapping(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int count = 0;
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < end){
                count++;
            }
            else end = intervals[i][1];
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,3},{1,4},{3,5},{3,4},{4,5}};
        System.out.println(nonOverlapping(arr));
    }
}
