import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }
        
        String[] answer = Arrays.copyOf(players, players.length);
        
        for (String back : callings) {
            int rank = playerMap.get(back);
            String front = answer[rank - 1];
            
            playerMap.put(front, rank);
            playerMap.put(back, rank - 1);
            answer[rank - 1] = back;
            answer[rank] = front;
        }
        
        return answer;
    }
}
