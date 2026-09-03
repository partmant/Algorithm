import java.util.*;

class Solution {
    static int[][] count;
    static int[] degree;
    static int[] result;
    
    public int solution(String[] friends, String[] gifts) {
        int f_len = friends.length;
        Map<String, Integer> map = new HashMap<>();
        count = new int[f_len+1][f_len+1];
        degree = new int[f_len];
        result = new int[f_len];
        
        for(int i=0;i<f_len;i++)
            map.put(friends[i], i);
        
        for(int i=0;i<gifts.length;i++) {
            String[] a = gifts[i].split(" ");
            count[map.get(a[0])][map.get(a[1])]++;
            count[map.get(a[0])][f_len]++;
            count[f_len][map.get(a[1])]++;
        }
        
        for(int i=0;i<friends.length;i++)   
            degree[i] = count[i][f_len] - count[f_len][i];
        
        for(int i=0;i<f_len-1;i++)    {
            for(int j=i+1;j<f_len;j++)  {
                if(count[i][j]>count[j][i])
                    result[i]++;
                else if(count[i][j]<count[j][i])
                    result[j]++;
                else    {
                    if(degree[i]>degree[j])
                        result[i]++;
                    else if(degree[j]>degree[i])
                        result[j]++;
                }
            }
        }
        
        int max = 0;
        for(int v:result)
            max = Math.max(max,v);
        
        return max;
    }
}