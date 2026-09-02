class Solution {
    public int solution(int n, long l, long r) {
        return (int) (countOne(n, r) - countOne(n, l - 1));
    }
    
    private long countOne(int depth, long idx) {
        if (depth == 0) return 1;
        if (idx == 0) return 0;
        
        long sectionLen = (long) Math.pow(5, depth - 1);
        long section = (idx - 1) / sectionLen;
        long remainder = (idx - 1) % sectionLen + 1;
        
        if (section == 2) {
            return (long) Math.pow(4, depth - 1) * 2;
        } else if (section < 2) {
            return (long) Math.pow(4, depth - 1) * section + countOne(depth - 1, remainder);
        } else {
            return (long) Math.pow(4, depth - 1) * (section - 1) + countOne(depth - 1, remainder);
        }
    }
}