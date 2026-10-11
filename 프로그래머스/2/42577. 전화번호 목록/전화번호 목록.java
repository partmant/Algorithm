import java.util.*;

class Solution {
    
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    static class Trie {
        TrieNode root = new TrieNode();
        
        public boolean insert(String number) {
            TrieNode cur = root;
            
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                
                if (i == number.length() - 1 && cur.children.containsKey(c)) {
                    return false;
                }
                
                cur = cur.children.computeIfAbsent(c, k -> new TrieNode());
            }
            
            return true;
        }
    
    }
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (a, b) -> b.length() - a.length());
        
        Trie trie = new Trie();
        
        for (String number : phone_book) {
            if (!trie.insert(number)) {
                return false;
            }
        }
        
        return true;
    }
}