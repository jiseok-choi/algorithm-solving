package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class ClickKeyPad {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Map<Integer, int[]> keypad = new HashMap<>();
        int[] xkey = new int[]{1,0,1};

        keypad.put(0, new int[]{0, 0});

        int i = 0;
        for (int y = 3; y > 0; y--) {
            for (int key : xkey) {
                i++;
                keypad.put(i, new int[]{key, y});
            }
        }

        int[] leftLocation = new int[]{1,0};
        int[] rightLocation = new int[]{1,0};

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                leftLocation = keypad.get(num);
                answer.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                rightLocation = keypad.get(num);
                answer.append("R");
            } else {
                int[] targetNum = keypad.get(num);
                int leftAbs = Math.abs(leftLocation[0] - targetNum[0]) + Math.abs(leftLocation[1] - targetNum[1]);
                int rightAbs = Math.abs(rightLocation[0] - targetNum[0]) + Math.abs(rightLocation[1] - targetNum[1]);
                if (leftAbs < rightAbs) {
                    answer.append("L");
                    leftLocation = targetNum;
                } else if (leftAbs > rightAbs) {
                    answer.append("R");
                    rightLocation = targetNum;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftLocation = targetNum;
                    } else {
                        answer.append("R");
                        rightLocation = targetNum;
                    }
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }
}
