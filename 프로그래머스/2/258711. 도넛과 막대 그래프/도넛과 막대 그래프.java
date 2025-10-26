import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        int[] inDegree = new int[1000001];
        int[] outDegree = new int[1000001];
        
        for(int[] t:edges)  {
            nodes.add(t[0]);
            nodes.add(t[1]);
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }
        
        int startNode = 0;
        for(int node:nodes) {
            if(inDegree[node]==0&&outDegree[node]>=2)   {
                startNode = node;
                break;
            }
        }
        
        int stick=0, eight=0;
        for(int node:nodes)  {
            if(node==startNode)
                continue;
            
            if(outDegree[node]==0)
                stick++;
            else if(inDegree[node]>=2&&outDegree[node]==2)
                eight++;
        }
        
        return new int[] {startNode, outDegree[startNode]-stick-eight, stick, eight };
    }
}