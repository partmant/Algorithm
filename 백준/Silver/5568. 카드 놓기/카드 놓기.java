import java.util.*;

class Main {
    static int n;
    static int k;
    static String[] nums;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        
        nums = new String[n];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
           nums[i] = sc.next(); 
        }
        
        dfs("", 0);
        
        System.out.print(set.size());
    }
    
    static void dfs(String value, int depth) {
        if (depth == k) {
            set.add(value);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(value + nums[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
