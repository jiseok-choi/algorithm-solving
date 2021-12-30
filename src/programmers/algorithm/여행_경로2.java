package programmers.algorithm;

import java.util.*;

/**
 * 여행경로
 * 문제 설명
 * 주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 *
 * 항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 * 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 * tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 * 주어진 항공권은 모두 사용해야 합니다.
 * 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 * 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 * 입출력 예
 * tickets	return
 * [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	["ICN", "JFK", "HND", "IAD"]
 * [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]	["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
 * 입출력 예 설명
 * 예제 #1
 *
 * ["ICN", "JFK", "HND", "IAD"] 순으로 방문할 수 있습니다.
 *
 * 예제 #2
 *
 * ["ICN", "SFO", "ATL", "ICN", "ATL", "SFO"] 순으로 방문할 수도 있지만 ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 가 알파벳 순으로 앞섭니다.
 */
public class 여행_경로2 {

    public Map<String, ArrayList<String>> airMap = new HashMap<>();

    public List<String> answerList = new ArrayList<>();


    public String[] solution(String[][] tickets) {

        int answerCnt = 1;
        // 공항 리스트 초기화 및 관계 정의
        for (int i = 0; i < tickets.length; i++) {

            if (airMap.get(tickets[i][0]) == null) {
                airMap.put(tickets[i][0], new ArrayList<>());
            }
            airMap.get(tickets[i][0]).add(tickets[i][1]);
            answerCnt++;
        }

        String key = "ICN";
        answerList.add(key);
        ArrayList<String> list;
        while (answerList.size() < answerCnt) {
            // 도착한곳에서 티켓목록 가져오기
            list = airMap.get(key);
            if (list == null) {
                break;
            }
            // 다음 티켓이 없는데 반복이 끝나지 않았다..
            if (list.size() == 0) {
                //
                airMap.get(answerList.get(answerList.size() - 2)).add(key);
                answerList.remove(answerList.size());
                list = airMap.get(answerList.get(answerList.size() - 1));
                key = list.get(0);
                answerList.add(key);
                list.remove(0);
            } else {
                // 알파벳 소팅
                Collections.sort(list);
                // 다음경로 첫번째 티켓 소지
                key = list.get(0);
                // 다음 공항 도착
                answerList.add(key);
                // 도착 티켓 제거
                list.remove(0);
            }
        }



        return answerList.toArray(new String[0]);
    }


    public static void main(String[] args) {
        여행_경로2 t = new 여행_경로2();
//        String[] solution = t.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] solution = t.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});
        for (String s : solution) {
            System.out.println(s);
        }

    }

    /*
    	결괏값 ["ICN","ATL","ICN","SFO","ATL","ICN","SFO","ATL","SFO"]이(가)
    	기댓값 ["ICN","ATL","ICN","SFO","ATL","SFO"]와(과) 다릅니다.
     */

}
