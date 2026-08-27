class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (t.charAt(i + j) < p.charAt(j)) {
                    answer++;
                    break;
                } else if (t.charAt(i + j) > p.charAt(j)) {
                    break;
                }
                
                if (j == p.length() - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}