import java.util.*;
class Keypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer, Integer[]> numMap = insertPosition();

        int leftHand = -1;
        int rightHand = -2;
        for(int n : numbers) {
            if(n != 0 && n % 3 == 0) {
                answer += "R";
                rightHand = n;
            }
            else if(n % 3 == 1) {
                answer += "L";
                leftHand = n;
            }
            else {
                Integer[] numPo = numMap.get(n);
                Integer[] leftPo = numMap.get(leftHand);
                Integer[] rightPo = numMap.get(rightHand);

                int leftDiff = getDistance(numPo, leftPo);
                int rightDiff = getDistance(numPo, rightPo);

                if(leftDiff == rightDiff) {
                    if(hand.equals("left")) {
                        answer += "L";
                        leftHand = n;
                    }
                    else {
                        answer += "R";
                        rightHand = n;
                    }
                }
                else if(leftDiff > rightDiff) {
                    answer += "R";
                    rightHand = n;
                }
                else {
                    answer += "L";
                    leftHand = n;
                }
            }
        }
        return answer;
    }

    private int getDistance(Integer[] numPo, Integer[] stanPo) {
        int xDis = numPo[0] - stanPo[0];
        int yDis = numPo[1] - stanPo[1];
        return Math.abs(xDis) + Math.abs(yDis);
    }

    private Map<Integer, Integer[]> insertPosition() {
        Map<Integer, Integer[]> numMap = new HashMap<>();

        numMap.put(0, new Integer[]{0,1});
        numMap.put(1, new Integer[]{3,0});
        numMap.put(2, new Integer[]{3,1});
        numMap.put(3, new Integer[]{3,2});
        numMap.put(4, new Integer[]{2,0});
        numMap.put(5, new Integer[]{2,1});
        numMap.put(6, new Integer[]{2,2});
        numMap.put(7, new Integer[]{1,0});
        numMap.put(8, new Integer[]{1,1});
        numMap.put(9, new Integer[]{1,2});
        numMap.put(-1, new Integer[]{0,0});
        numMap.put(-2, new Integer[]{0,2});
        return numMap;
    }
}