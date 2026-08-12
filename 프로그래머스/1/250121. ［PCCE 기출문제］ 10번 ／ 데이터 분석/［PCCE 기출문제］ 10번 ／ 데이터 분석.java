import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        
        int extIdx = findIdx(ext);
        int sortIdx = findIdx(sort_by);
        
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }
        
        Collections.sort(list, (a, b) -> a[sortIdx] - b[sortIdx]);

        return list.toArray(new int[0][]);
    }
    
    private int findIdx(String s) {
        return switch (s) {
            case "code" -> 0;
            case "date" -> 1;
            case "maximum" -> 2;
            case "remain" -> 3;
            default -> -1;
        };
    }
}