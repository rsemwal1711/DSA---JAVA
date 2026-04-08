package GREEDY_ALGOS;

public class _5ValidParenthesis {
    public static boolean valid_rec(String s, int index, int open){
        if(open < 0) return false;
        if(s.length() == index){
            return open == 0;
        }
        char c = s.charAt(index);
        if(c == '('){
            return valid_rec(s, index+1, open+1);
        }
        else if(c == ')'){
            return valid_rec(s, index+1, open-1);
        }
        else{
            return valid_rec(s,index+1, open+1) || valid_rec(s,index+1,open-1) || valid_rec(s,index+1,open);
        }
    }

    public static boolean valid_OPTIMAL(String s){
        int mini = 0;
        int maxi = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                mini++;
                maxi++;
            }
            else if(c == ')'){
                mini--;
                maxi--;
            }
            else{
                mini--;
                maxi++;
            }
            if(maxi < 0) return false;
            if(mini < 0) mini = 0;
        }
        return mini == 0;
    }
    public static void main(String[] args) {
        System.out.println(valid_rec("(()*(", 0, 0));
        System.out.println(valid_OPTIMAL("(()*("));
    }
}
