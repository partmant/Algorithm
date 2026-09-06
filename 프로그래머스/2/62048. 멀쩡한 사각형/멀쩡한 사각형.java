class Solution {
    public long solution(int w, int h) {
        long longW = (long) w;
        long longH = (long) h;
        
        long gcd = gcd(longW, longH);
        
        return (longW * longH) - (longW + longH - gcd);
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}