package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class 뉴스_클러스터링 {

    public static double multiple = 65536;

    public static int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> str1Map = makeMap(str1);
        Map<String, Integer> str2Map = makeMap(str2);

        double kyo = 0;
        double hap = 0;

        // 교집합 구하기
        for (String s : str1Map.keySet()) {
            if (str2Map.containsKey(s)) {
                kyo += Math.min(str1Map.get(s), str2Map.get(s));
                hap += Math.max(str1Map.get(s), str2Map.get(s));
                str2Map.remove(s);
            } else {
                hap += str1Map.get(s);
            }
        }

        for (String s2 : str2Map.keySet()) {
            hap += str2Map.get(s2);
        }

        if (kyo == 0 || hap == 0) {
            kyo = 1;
            hap = 1;
        }

        answer = (int) ((kyo / hap) * multiple);

        return answer;
    }

    public static boolean match(String str) {
        return Pattern.matches("^[a-zA-Z]*$", str);
    }

    public static HashMap<String, Integer> makeMap(String str) {
        HashMap<String, Integer> strMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String tmpStr = str.substring(i, i + 2).toLowerCase();
            if (match(tmpStr)) {
                if (strMap.containsKey(tmpStr)) {
                    strMap.put(tmpStr, strMap.get(tmpStr) + 1);
                } else {
                    strMap.put(tmpStr, 1);
                }
            }
        }
        return strMap;
    }

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
    }
}
