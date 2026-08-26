import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int todayDays = dateToDays(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int startDays = dateToDays(privacy[0]);
            int termMonth = termMap.get(privacy[1]);
            
            if (todayDays >= startDays + (termMonth * 28)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dateToDays(String date) {
        String[] parsedDate = date.split("\\.");
        int year = Integer.parseInt(parsedDate[0]);
        int month = Integer.parseInt(parsedDate[1]);
        int day = Integer.parseInt(parsedDate[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}
