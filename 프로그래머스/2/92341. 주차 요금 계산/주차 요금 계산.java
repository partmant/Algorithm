import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        Map<String, Integer> inTime = new HashMap<>();
        Map<String, Integer> totalTime = new TreeMap<>();

        for (String record : records) {
            String[] parsed = record.split(" ");
            String[] timeStr = parsed[0].split(":");
            int curTime = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);
            String carNum = parsed[1];
            String type = parsed[2];

            if (type.equals("IN")) {
                inTime.put(carNum, curTime);
            } else {
                int parkedTime = curTime - inTime.remove(carNum);
                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parkedTime);
            }
        }

        // 출차 기록이 없는 차량 처리
        int maxTime = 23 * 60 + 59;
        for (String carNum : inTime.keySet()) {
            int parkedTime = maxTime - inTime.get(carNum);
            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + parkedTime);
        }

        // 차량별 최종 요금 계산
        int[] answer = new int[totalTime.size()];
        int idx = 0;

        for (int time : totalTime.values()) {
            if (time <= baseTime) {
                answer[idx++] = baseFee;
            } else {
                int extraTime = time - baseTime;
                int extraFee = ((extraTime + unitTime - 1) / unitTime) * unitFee;
                answer[idx++] = baseFee + extraFee;
            }
        }

        return answer;
    }
}