
class Solution {
    boolean solution(String s) {
        if(s.charAt(0) == ')')
            return false;

        int count=0;
        for(int i=0;i<s.length();i++)   {
            if(count>=0){
                char now = s.charAt(i);
                if(now=='(')
                    count++;
                else if(now==')')
                    count--;
            }
            else 
                return false;
        }
        if(count==0)
            return true;
        else
            return false;
    }
}