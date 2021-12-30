package programmers.algorithm;

import java.util.*;

public class TravelRoute {

    public String[] solution(String[][] tickets) {

        int n = tickets.length;

        // 그래프의 인접리스트를 표한할 map
        Map<String, List<Ticket>> ticketMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ticketMap
                .computeIfAbsent(tickets[i][0], (v) -> new LinkedList<>())
                .add(new Ticket(i, tickets[i][1]));
        }

        // 각 티겟을 사용했는지 여부를 체크한다.
        boolean[] ticketUsed = new boolean[n];

        // 티켓을 사용하며 여행루트를 담을 배열. 출발지(1) + 티켓 수(n)
        String[] route = new String[n + 1];

        route[0] = "ICN";

        // 인천을 ROOT 로 정점을 순회할 깊이탐색 메소드를 호출.
        dfs(ticketMap, n, ticketUsed, 0, "ICN", route);

        return route;
    }

    boolean dfs(Map<String, List<Ticket>> ticketMap, int ticketCnt, boolean[] ticketUsed, int usedCnt, String departure, String[] route) {

        if (ticketCnt == usedCnt) {
            // 티켓이 다 사용된 경우
            return true;
        }

        // 출발지에서 갈수있는 티겟을 가져와 순회하여 dfs 메소드를 호출함
        List<Ticket> arrives = ticketMap.get(departure);

        // 갈 수 있는 티켓이 없다면 종료
        if (arrives == null) return false;

        // 알파벳 순으로 방문하기 위해 소팅함
        Collections.sort(arrives);

        for (Ticket ticket : arrives) {

            // 사용된 티켓이 아니라면 다음을 수행
            if (!ticketUsed[ticket.id]) {

                // 티켓이 사용되었다고 표시함
                ticketUsed[ticket.id] = true;

                // 여행 경로에 도착지를 넣고 (최초 출발지 때문에 +1 함)
                route[usedCnt + 1] = ticket.arrive;

                // 다음 여행지를 구하러 dfs 호출
                if (dfs(ticketMap, ticketCnt, ticketUsed, usedCnt + 1, ticket.arrive, route)) {
                    // 성공적으로 루트를 찾았으므로 성공을 리턴하고 다음을 실행하지 못하게 함.
                    return true;
                }

                // 여행경로를 못찾았기에 돌아갈 수 있도록 티켓 사용을 해제함.
                ticketUsed[ticket.id] = false;
            }
        }

        // 더이상 방문할 곳이 없으므로 재귀 호출 종료
        return false;
    }


    // 티켓 정보를 담을 클래스
    class Ticket implements Comparable<Ticket> {
        int id;
        String arrive;
        Ticket(int id, String arrive) {
            this.id = id;
            this.arrive = arrive;
        }

        @Override
        public int compareTo(Ticket ticket) {
            return arrive.compareTo(ticket.arrive);
        }
    }

    public static void main(String[] args) {
        TravelRoute t = new TravelRoute();
//        String[] solution = t.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        String[] solution = t.solution(new String[][]{{"ICN", "AOO"}, {"AOO", "BOO"}, {"BOO", "COO"}, {"COO", "DOO"}, {"DOO", "EOO"}, {"EOO", "DOO"}, {"DOO", "COO"}, {"COO", "BOO"}, {"BOO", "AOO"}});
        for (String s : solution) {
            System.out.println(s);
        }

    }

}
