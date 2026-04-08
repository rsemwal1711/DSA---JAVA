package GREEDY_ALGOS;
import java.util.*;

public class _1AssignCookies {
    public static int assignCookies(int[] student, int[] cookies){
        Arrays.sort(student);
        Arrays.sort(cookies);
        int studentIndex = 0;
        int cookiesIndex = 0;
        while(studentIndex < student.length && cookiesIndex < cookies.length){
            if(cookies[cookiesIndex] >= student[studentIndex]){
                studentIndex++;
            }
            cookiesIndex++;
        }
        return studentIndex;
    }
    public static void main(String[] args) {
        int[] student = {1,2,3,4,5};
        int[] cookies = {10,20,30,40,0};
        System.out.println(assignCookies(student, cookies));
    }
}
