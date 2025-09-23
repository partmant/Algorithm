import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String k : participant)
            map.put(k, map.getOrDefault(k, 0) + 1);
        
        for(String k : completion)
            map.put(k, map.get(k) - 1);
        
        for(String k : map.keySet())
            if(map.get(k)==1)
                return k;
        
        return "";
    }
}