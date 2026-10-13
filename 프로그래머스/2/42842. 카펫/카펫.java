class Solution {
    public int[] solution(int brown, int yellow) {
        int totalSize = brown + yellow;
        
        for (int h = 3; h <= Math.sqrt(totalSize); h++) {
            if (totalSize % h == 0) {
                int w = totalSize / h;
                if ((h - 2) * (w - 2) == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        return new int[]{0, 0};
    }
}