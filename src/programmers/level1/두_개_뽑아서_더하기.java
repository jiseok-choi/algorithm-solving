package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 두_개_뽑아서_더하기 {
    public static int[] solution(int[] numbers) {
        int[] answer;

//        Comparator<Integer> comparator = (s1, s2)->s1.compareTo(s2);
//        Map<Integer, Integer> map = new TreeMap<>(comparator);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int num = numbers[i] + numbers[j];
                if (num != 0 && !list.contains(num))
                    list.add(num);
            }
        }

        answer = new int[list.size()];

        int index = 0;

        Collections.sort(list);

        for (int n : list) {
            answer[index] = n;
            index++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[] {1,1,1});
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        for (int n : answer) {
            System.out.println(n);
        }
    }
}
