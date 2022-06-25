package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 가장큰수 {

    /**
     * 문제 설명
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     *
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     *
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한 사항
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     * 입출력 예
     * numbers	return
     * [6, 10, 2]	"6210"
     * [3, 30, 34, 5, 9]	"9534330"
     */

    public String solution(int[] numbers) {

        List<BigNumObj> bigNumObjs = new ArrayList<>();
        int total = 0;

        for (int num : numbers) {
            bigNumObjs.add(new BigNumObj(num));
            total += num;
        }

        if (total == 0) {
            return "0";
        }

        bigNumObjs.sort(Comparator.reverseOrder());

        StringBuilder builder = new StringBuilder();

        for (BigNumObj str : bigNumObjs) {
            builder.append(str.num);
        }

        return builder.toString();
    }

    public static class BigNumObj implements Comparable<BigNumObj> {

        private final String num;

        public BigNumObj(Integer num) {
            this.num = num.toString();
        }

        @Override
        public int compareTo(BigNumObj o) {
            return (this.num + o.num).compareTo(o.num + this.num);
        }
    }

    public static void main(String[] args) {
        String big = "9534330";
        String small = "9330345";
        System.out.println(small.compareTo(big));

        System.out.println();
        가장큰수 clazz = new 가장큰수();
        System.out.println(clazz.solution(
                new int[]{3, 30, 34, 5, 9}
//                new int[]{0, 0, 0, 0}
        ));

        System.out.println(Integer.parseInt("0000"));
    }
}
