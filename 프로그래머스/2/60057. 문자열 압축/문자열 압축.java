import java.util.*;

class Solution {
    public int solution(String s) {
        int minSize = s.length();
        
        for (int size = 1; size <= s.length() / 2; size++) {
            minSize = Math.min(minSize, compress(size, s));
        }
        
        return minSize;
    }
    
    private int compress(int size, String s) {
        StringBuilder compressed = new StringBuilder();
        String prev = s.substring(0, size);
        int cnt = 1;
        
        for (int i = size; i < s.length(); i += size) {
            int endIdx = Math.min(i + size, s.length());
            String cur = s.substring(i, endIdx);
            
            if (prev.equals(cur)) {
                cnt++;
            } else {
                if (cnt > 1) compressed.append(cnt);
                compressed.append(prev);
                prev = cur;
                cnt = 1;
            }
        }
        
        if (cnt > 1) compressed.append(cnt);
        compressed.append(prev);
        
        return compressed.length();
    }
}