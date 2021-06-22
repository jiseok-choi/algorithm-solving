package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */

public class MockExam {

    static public int[] solution(int[] answers) {

        int[] pattern1 = { 1,2,3,4,5 };
        int[] pattern2 = { 2,1,2,3,2,4,2,5 };
        int[] pattern3 = { 3,3,1,1,2,2,4,4,5,5 };

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

        int [][] arr = {{patternCount1, 1}, {patternCount2, 2}, {patternCount3, 3}};
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
            return new int[] {arr[2][1], arr[1][1], arr[0][1]};
        } else if (arr[0][0] == arr[1][0]) {
            return new int[] {arr[0][1], arr[1][1]};
        } else {
            return new int[] {arr[0][1]};
        }

    }

    public static void main(String[] args) {
        int[] pattern1 = { 1,2,3,4,5 };
        int[] pattern2 = { 2,1,2,3,2,4,2,5 };
        int[] pattern3 = { 3,3,1,1,2,2,4,4,5,5 };

//        System.out.println(Math.max(19, 19));

        int[] arr = solution(new int[] {1,2,3,4,5});

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

//        for (int i = 0; i < 19; i++) {
//            System.out.println(pattern1[i % pattern1.length]);
//            System.out.println(i % pattern2.length);
//            System.out.println(i % pattern3.length);
//            System.out.println("=============");
//        }
    }
}
