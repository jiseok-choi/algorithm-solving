package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {
    class Solution {
        public int[] solution(int[] answers) {

            int[] pattern1 = {1, 2, 3, 4, 5};
            int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int patternCount1 = 0, patternCount2 = 0, patternCount3 = 0;

            for (int i = 0; i < answers.length; i++) {

                if (pattern1[i % pattern1.length] == answers[i]) {
                    patternCount1++;
                }
                if (pattern2[i % pattern2.length] == answers[i]) {
                    patternCount2++;
                }
                if (pattern3[i % pattern3.length] == answers[i]) {
                    patternCount3++;
                }
            }

            int bigRecord = Math.max(patternCount1, patternCount2);
            bigRecord = Math.max(bigRecord, patternCount2);

            if (bigRecord == 0) {
                return new int[0];
            }

            List<Integer> list = new ArrayList<>();

            if (bigRecord == patternCount1) {
                list.add(1);
            }
            if (bigRecord == patternCount2) {
                list.add(2);
            }
            if (bigRecord == patternCount3) {
                list.add(3);
            }

            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
/*
            int[][] arr = {{patternCount1, 1}, {patternCount2, 2}, {patternCount3, 3}};
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o2[0] - o1[0];
                    }
                }
            });


            if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) {
                return new int[]{arr[2][1], arr[1][1], arr[0][1]};
            } else if (arr[0][0] == arr[1][0]) {
                return new int[]{arr[1][1], arr[0][1]};
            } else {
                return new int[]{arr[0][1]};
            }
*/
        }
    }
}
