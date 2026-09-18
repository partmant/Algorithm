class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyBottle = n;
        
        while (emptyBottle >= a) {
            int exchangedCoke  = (emptyBottle / a) * b;
            answer += exchangedCoke;
            emptyBottle = (emptyBottle % a) + exchangedCoke;
        }
        
        return answer;
    }
}