class Solution {
    public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        for(int i=1; k*i<=n; i++) 
            answer[i-1] = k*i;
        
        return answer;
    }
}