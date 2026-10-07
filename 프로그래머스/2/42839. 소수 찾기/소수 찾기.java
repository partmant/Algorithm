import java.util.*;

class Solution {
    
    private Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        generateCombinations(numbers, visited, "");
        
        int answer = 0;
        for (int n : numberSet) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private void generateCombinations(String numbers, boolean[] visited, String cur) {
        if (!cur.isEmpty()) {
            numberSet.add(Integer.parseInt(cur));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateCombinations(numbers, visited, cur + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}