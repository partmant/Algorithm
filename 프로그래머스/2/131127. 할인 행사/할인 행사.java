import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> cart = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
        }
        
        int answer = 0;
        if (canBuyAll(cart, want, number)) {
            answer++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            cart.put(discount[i - 10], cart.get(discount[i - 10]) - 1);
            cart.put(discount[i], cart.getOrDefault(discount[i], 0) + 1);
            
            if (canBuyAll(cart, want, number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean canBuyAll(Map<String, Integer> cart, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (cart.getOrDefault(want[i], 0) < number[i]) {
                return false;
            }
        }
        return true;
    }
}