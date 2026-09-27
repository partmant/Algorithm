import java.util.*;

class Solution {
    public int solution(String dirs) {
        int x = 5;
        int y = 5;
        
        Set<String> visited = new HashSet<>();
        
        for (char dir : dirs.toCharArray()) {
            int nx = x;
            int ny = y;
            
            if (dir == 'U') ny++;
            else if (dir == 'D') ny--;
            else if (dir == 'R') nx++;
            else if (dir == 'L') nx--;
            
            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            visited.add(x + "" + y + "" + nx + "" + ny);
            visited.add(nx + "" + ny + "" + x + "" + y);
            
            x = nx;
            y = ny;
        }
        
        return visited.size() / 2;
    }
}