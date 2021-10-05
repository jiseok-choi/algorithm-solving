package programmers.level1;

/**
 * 문제 설명
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 1 이상 100,000,000 이하인 자연수입니다.
 * 입출력 예
 * n	result
 * 45	7
 * 125	229
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 답을 도출하는 과정은 다음과 같습니다.
 * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
 * 45	1200	0021	7
 * 따라서 7을 return 해야 합니다.
 * 입출력 예 #2
 *
 * 답을 도출하는 과정은 다음과 같습니다.
 * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
 * 125	11122	22111	229
 * 따라서 229를 return 해야 합니다.
 */

public class 삼진법_뒤집기 {
    public static int solution(int n) {
        int answer = 0;

        StringBuilder numStr = new StringBuilder();
        while (n > 0) {
            numStr.append((n % 3));
            n /= 3;
        }

        System.out.println(numStr);

        String[] reverseList = numStr.reverse().toString().split("");

        int index = 0;
        int jinsu = 1;
        for (String s : reverseList) {
            if (index == 0) {
                answer = Integer.parseInt(s);
            } else {
                answer += jinsu * Integer.parseInt(s);
            }

            index = 1;
            jinsu *= 3;
        }

        return answer;
    }

    // 우수 코드
    public static int solution2(int n) {
        String a = "";

        while(n > 0){
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a,3);
    }

    public static void main(String[] args) {
        System.out.println(solution2(125));
    }
}
