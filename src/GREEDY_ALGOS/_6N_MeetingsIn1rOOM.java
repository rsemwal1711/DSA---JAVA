package GREEDY_ALGOS;

import java.util.ArrayList;
import java.util.*;

public class _6N_MeetingsIn1rOOM {
    public static List<Integer> howManyMeetings(int[] start, int[] end){
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            list.add(new int[] {start[i], end[i], i+1});
        }
        list.sort(Comparator.comparingInt(a -> a[1]));
        List<Integer> ans = new ArrayList<>();
        int last = -1;
        for(int[] item : list){
            if(item[0] > last){
                ans.add(item[2]);
                last = item[1];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] start = {0,3,1,5,5,8};
        int[] end = {5,4,2,9,7,9};
        System.out.println(howManyMeetings(start, end));
    }
}
