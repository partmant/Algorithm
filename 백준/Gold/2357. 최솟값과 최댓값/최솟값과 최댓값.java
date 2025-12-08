import java.util.*;

class Main {
    static int[] maxHeap;
    static int[] minHeap;
    static int leafCount;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        leafCount = 1;
        while (leafCount < N) {
            leafCount <<= 1;
        }
        int size = leafCount * 2;
        
        maxHeap = new int[size];
        minHeap = new int[size];
        
        Arrays.fill(minHeap, Integer.MAX_VALUE);
        Arrays.fill(maxHeap, Integer.MIN_VALUE);
        
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            maxHeap[leafCount + i - 1] = num;
            minHeap[leafCount + i - 1] = num;
        }
        
        for (int i = leafCount - 1; i > 0; i--) {
            int leftIdx = i * 2;
            int rightIdx = i * 2 + 1;

            maxHeap[i] = Math.max(maxHeap[leftIdx], maxHeap[rightIdx]);
            minHeap[i] = Math.min(minHeap[leftIdx], minHeap[rightIdx]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int b = sc.nextInt();
            int e = sc.nextInt();
            
            int[] result = queryMinMax(b, e);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int[] queryMinMax(int begin, int end) {
        begin += leafCount - 1;
        end += leafCount - 1;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        while (begin <= end) {
            if ((begin & 1) == 1) {
                minVal = Math.min(minVal, minHeap[begin]);
                maxVal = Math.max(maxVal, maxHeap[begin]);
                begin++;
            }
            if ((end & 1) == 0) {
                minVal = Math.min(minVal, minHeap[end]);
                maxVal = Math.max(maxVal, maxHeap[end]);
                end--;
            }
            begin >>= 1;
            end >>= 1;
        }
        return new int[]{minVal, maxVal};
    }
}
