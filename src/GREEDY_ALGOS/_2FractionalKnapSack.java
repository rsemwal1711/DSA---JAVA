package GREEDY_ALGOS;

import java.util.ArrayList;
import java.util.*;

public class _2FractionalKnapSack {
    public static double knapSack(int[] value, int[] weight, int wt){

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<weight.length;i++){
            list.add(new int[] {weight[i], value[i]});
        }
        list.sort(Comparator.comparingDouble((int[] a) -> (double) a[1]/a[0]).reversed());
//        for(int[] item : list){
//            System.out.println(item[0] + " " + item[1]);
//        }

        double finalValue = 0.0;
        int weightCount = 0;
        for(int[] item : list){
            if(weightCount + item[0] <= wt){
                finalValue += item[1];
                weightCount += item[0];
            }
            else{
                int remain = wt - weightCount;
                finalValue += ((double) item[1]/item[0]) * remain;
                break;
            }
        }
        return finalValue;
    }
    public static void main(String[] args) {
        int[] value = {60,100,120};
        int[] weight = {20,30,30};
        int wt = 50;

        System.out.println(knapSack(value, weight, wt));
    }
}
