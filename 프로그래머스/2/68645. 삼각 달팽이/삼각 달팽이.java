class Solution {
    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] triangle = new int[size];
        
        int row = -1;
        int col = 0;
        int num = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                
                triangle[row * (row + 1) / 2 + col] = num++;
            }
        }
        
        return triangle;
    }
}