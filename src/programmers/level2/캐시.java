package programmers.level2;

import java.util.*;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Map<String, Integer> cache = new HashMap<>();

        int sort = 0;
        for (String city : cities) {
            if (add(cache, city.toLowerCase(), cacheSize, sort++)) {
                answer++;
            } else {
                answer += 5;
            }
        }

        return answer;
    }

    private boolean add(Map<String, Integer> cache, String str, int limitSize, int sort) {
        boolean result = cache.containsKey(str);
        cache.put(str, sort);
        if (cache.size() > limitSize) {
            int minValue = Integer.MAX_VALUE;
            String minKey = "";
            for (String key : cache.keySet()) {
                if (cache.get(key) < minValue) {
                    minValue = cache.get(key);
                    minKey = key;
                }
            }
            cache.remove(minKey);
        }
        return result;
    }

    public static void main(String[] args) {
        캐시 clazz = new 캐시();
        System.out.println(
                clazz.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})
        );
    }

}
