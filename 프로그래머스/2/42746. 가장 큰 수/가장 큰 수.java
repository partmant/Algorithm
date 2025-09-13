import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arrays = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<arrays.length;i++) 
            arrays[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(arrays, (a,b)->(b+a).compareTo(a+b));
        
        if(arrays[0].equals("0"))
            return "0";
        
        for(String s:arrays)
            sb.append(s);
        
        return sb.toString();
    }
}