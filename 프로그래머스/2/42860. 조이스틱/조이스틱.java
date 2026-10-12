import java.util.*;

class Solution {
    public int solution(String name) {
        int upDownChanges = 0;
        int minCursorMoves = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            upDownChanges += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 i까지 갔다가 돌아서 뒤쪽 처리
            minCursorMoves = Math.min(minCursorMoves, (i * 2) + (name.length() - next));

            // 뒤쪽을 먼저 갔다가 돌아와서 앞쪽 처리
            minCursorMoves = Math.min(minCursorMoves, (name.length() - next) * 2 + i);
        }
        
        return upDownChanges + minCursorMoves;
    }
}