package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 소수 찾기
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */
public class 소수_찾기 {

    public static List<String> ANSWER = new ArrayList<>();

    public int solution(String numbers) {

        Map<Integer, Integer> resultMap = new HashMap<>();

        // 숫자 배열 생성
        String[] strNumList = numbers.split("");

        // 순열
        for (int r = 1; r <= strNumList.length; r++) {
            permutation(strNumList, strNumList.length, r, 0, ANSWER);
        }

        for (String str : ANSWER) {

            int targetN = Integer.parseInt(str);
            int sqrt = (int)Math.sqrt(targetN);
            boolean isSosu = true;
            if (targetN <= 1) {
                continue;
            }

            for (int i = 2; i <= sqrt; i++) {
                if (targetN % i == 0) {
                    isSosu = false;
                }
            }
            if (isSosu) {
                resultMap.put(targetN, 0);
            }
        }
        return resultMap.size();
    }

    private void permutation(String[] strNumList, int n, int r, int pos, List<String> answer) {
        if (r == pos) { // 모두 뽑았을때
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < r; i++) {
                ans.append(strNumList[i]);
            }
            answer.add(ans.toString());
        }

        for (int i = pos; i < n; i++) {
            swap(strNumList, pos, i);

            permutation(strNumList, n, r, pos + 1, answer);

            swap(strNumList, pos, i);
        }
    }

    public void swap(String[] arr, int n1, int n2) {
        String temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
