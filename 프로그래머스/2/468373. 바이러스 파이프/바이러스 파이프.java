import java.util.*;

class Solution {

    static class Node {
        int to;
        int type;

        Node(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    private int n;
    private int k;
    private int maxInfected = 0;
    private List<List<Node>> graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.k = k;

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int type = edge[2];
            graph.get(from).add(new Node(to, type));
            graph.get(to).add(new Node(from, type));
        }

        boolean[] isInfected = new boolean[n + 1];
        isInfected[infection] = true;

        selectPipeTypes(0, isInfected);

        return maxInfected;
    }

    private void selectPipeTypes(int depth, boolean[] isInfected) {
        int curInfectedCnt = countInfected(isInfected);
        maxInfected = Math.max(maxInfected, curInfectedCnt);

        if (curInfectedCnt == n || depth == k) {
            return;
        }

        for (int type = 1; type <= 3; type++) {
            boolean[] nextIsInfected = isInfected.clone();
            spreadVirus(nextIsInfected, type);
            selectPipeTypes(depth + 1, nextIsInfected);
        }
    }

    private void spreadVirus(boolean[] isInfected, int type) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (isInfected[i]) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node next : graph.get(cur)) {
                if (next.type == type && !isInfected[next.to]) {
                    isInfected[next.to] = true;
                    q.add(next.to);
                }
            }
        }
    }

    private int countInfected(boolean[] isInfected) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isInfected[i]) {
                count++;
            }
        }
        return count;
    }
}