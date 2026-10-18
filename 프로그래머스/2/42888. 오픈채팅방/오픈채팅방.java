import java.util.*;

class Solution {
    
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String OUT_MESSAGE = "님이 나갔습니다.";
    
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        
        for (String log : record) {
            String[] parsed = log.split(" ");
            if (!parsed[0].equals("Leave")) {
                nicknameMap.put(parsed[1], parsed[2]);
            }
        }
        
        List<String> answerList = new ArrayList<>();
        for (String log : record) {
            String[] parsed = log.split(" ");
            
            if (parsed[0].equals("Enter")) {
                answerList.add(nicknameMap.get(parsed[1]) + ENTER_MESSAGE);
            } else if (parsed[0].equals("Leave")) {
                answerList.add(nicknameMap.get(parsed[1]) + OUT_MESSAGE);
            }
        }
        
        return answerList.toArray(new String[0]);
    }
}