package GREEDY_ALGOS;

import java.util.Arrays;

public class _12ShortestJobFirst {
    public static int SJF(int[] arr){
        Arrays.sort(arr);
        int waitTime = 0;
        int totalTime = 0;
        for (int j : arr) {
            waitTime += totalTime;
            totalTime += j;
        }
        return waitTime / arr.length;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,7,2,1};
        System.out.println(SJF(arr));
    }
}