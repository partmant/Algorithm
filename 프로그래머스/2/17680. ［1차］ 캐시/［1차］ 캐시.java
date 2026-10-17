import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int runTime = 0;
            
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String cur = cities[i].toLowerCase();
            if (q.contains(cur)) {
                q.remove(cur);
                q.offer(cur);
                runTime++;
            } else {    // 캐시에 없으면
                if (q.size() == cacheSize) {
                    q.poll();
                } 
                q.offer(cur);
                runTime += 5;
            }
        }
        
        return runTime;
    }
}