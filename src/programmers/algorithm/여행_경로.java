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
public class 여행_경로 {

    public Map<String, ArrayList<Ticket>> airMap = new HashMap<>();
    public Stack<Ticket> arriveStack = new Stack<>();
    int answerLength;

    class Ticket implements Comparable<Ticket> {
        String airPort;
        boolean used;

        Ticket(String airPort) {
            this.airPort = airPort;
            this.used = false;
        }

        @Override
        public int compareTo(Ticket ticket) {
            return airPort.compareTo(ticket.airPort);
        }
    }

    public String[] solution(String[][] tickets) {

        answerLength = tickets.length;

        // 공항 리스트 초기화 및 관계 정의
        for (int i = 0; i < tickets.length; i++) {

            if (airMap.get(tickets[i][0]) == null) {
                airMap.put(tickets[i][0], new ArrayList<>());
            }
            airMap.get(tickets[i][0]).add(new Ticket(tickets[i][1]));
        }

        String[] answer = new String[answerLength + 1];
        answer[0] = "ICN";

        dfs(0, "ICN", answer);

        return answer;
    }

    public boolean dfs(int usedCnt, String departure, String[] answer) {

        // 티켓 다 사용?
        if (answerLength == usedCnt) {
            return true;
        }

        // 출발지에서 갈 수 있는 티켓 가져와 순회! 해서 dfs 메소드 호출
        List<Ticket> arrives = airMap.get(departure);

        // 갈 수 있는 티켓 검사
        if (arrives == null) return false;

        // 알파벳 순 소팅
        Collections.sort(arrives);

        for (Ticket ticket : arrives) {

            // 사용된 티켓인가?
            if (!ticket.used) {
                // 티켓 사용
                ticket.used = true;

                // 여행 경로에 도착지 넣기
                answer[usedCnt + 1] = ticket.airPort;

                // 다음 여행지 구하러 dfs 호출
                if (dfs(usedCnt + 1, ticket.airPort, answer)) {
                    return true;
                }

                ticket.used = false;
            }
        }

        return false;
    }




    public static void main(String[] args) {
        여행_경로 t = new 여행_경로();
//        String[] solution = t.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] solution = t.solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        for (String s : solution) {
            System.out.println(s);
        }

    }

}
