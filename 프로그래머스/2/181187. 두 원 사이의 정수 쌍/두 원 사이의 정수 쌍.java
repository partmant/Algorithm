class Solution {
	public long solution(int r1, int r2) {
		long sum = 0;

		for (long x = 0; x < r2; x++) {
			if (x < r1) {
                long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));
                long minY = (long) Math.ceil(Math.sqrt((long) r1 * r1 - x * x));
                sum += (maxY - minY + 1);
            } else {
                long maxY = (long) Math.floor(Math.sqrt((long) r2 * r2 - x * x));
                sum += maxY;
            }
		}
		
		return sum * 4;
	}
}
