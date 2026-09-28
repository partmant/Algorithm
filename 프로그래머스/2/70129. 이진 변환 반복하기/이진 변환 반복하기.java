class Solution {
    public int[] solution(String s) {
        int transCnt = 0;
        int zeroCnt = 0;
        
        while (!s.equals("1")) {
            int onesCnt = countOnes(s);
            
            zeroCnt += s.length() - onesCnt;
            s = Integer.toBinaryString(onesCnt);
            
            transCnt++;
        }
        
        return new int[]{transCnt, zeroCnt};
    }
    
    private int countOnes(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
        }
        
        return cnt;
    }
}