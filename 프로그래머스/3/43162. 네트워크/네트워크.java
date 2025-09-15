import java.util.*;
class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<computers.length;i++)  {
            if(!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int[][] computers, int start)   {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;
            
            for(int i=0;i<computers[now].length;i++)    {
                if(computers[now][i]==1)    {
                    if(!visited[i]) {
                        visited[i]=true;
                        q.add(i);
                    }
                }
            }
        }
    }
}