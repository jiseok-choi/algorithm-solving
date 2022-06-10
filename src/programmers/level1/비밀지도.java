package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 비밀지도 {

    private static final String WALL = "#";
    private static final String NONE = " ";

    public String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(
                    getRow(n, binaryConvertDecimal(n, arr1[i]), binaryConvertDecimal(n, arr2[i]))
            );
        }

        return map.toArray(new String[0]);
    }

    // 나누기
    private String binaryConvertDecimal(int n, int num) {
        String decimalTxt = Integer.toBinaryString(num);
        StringBuilder preStr = new StringBuilder();
        for (int i = 0; i < n - decimalTxt.length(); i++) {
            preStr.append("0");
        }
        return preStr + Integer.toBinaryString(num);
    }


    // 결과 도출
    private String getRow(int n, String row1, String row2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (row1.toCharArray()[i] == '0' && row2.toCharArray()[i] == '0') {
                builder.append(NONE);
            } else {
                builder.append(WALL);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        비밀지도 clazz = new 비밀지도();
        System.out.println(Arrays.toString(clazz.solution(
                5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}
        )));
    }
}
