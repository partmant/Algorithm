import java.io.*;
import java.util.*;

public class Main {
    
    static class Node {
        Map<String, Node> children = new TreeMap<>();
    }

    static StringBuilder sb = new StringBuilder();

    static void dfs(Node node, int depth) {
        for (String key : node.children.keySet()) {
            sb.append(" ".repeat(depth))
                .append(key)
                .append('\n');
            
            dfs(node.children.get(key), depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        Node root = new Node();

        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split("\\\\");
            Node cur = root;

            for (String part : parts) {
                cur.children.putIfAbsent(part, new Node());
                cur = cur.children.get(part);
            }
        }

        dfs(root, 0);
        
        System.out.print(sb);
    }
}
