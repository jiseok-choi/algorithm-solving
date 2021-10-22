package programmers.level3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 네트워크
 * 문제 설명
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어,
 * 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * 제한사항
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 * 입출력 예
 * n	computers	return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 */
public class 네트워크 {

    // 노드 정보
    class Node {
        int data; // 노드 아이디
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    // 노드를 담는 배열
    Node[] nodes;

    public int solution(int n, int[][] computers) {

        int answer = 0;

        // 노드 개수에 맞는 배열 생성
        nodes = new Node[n];

        // 아이디별 노드 생성
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        // 노드간 관계 정의
        for (int i = 0; i < computers.length; i++) {
            for (int j = i + 1; j < computers.length; j++) {
                if (computers[i][j] == 1) {
                    Node n1 = nodes[i];
                    Node n2 = nodes[j];
                    if (!n1.adjacent.contains(n2)) {
                        n1.adjacent.add(n2);
                    }
                    if (!n2.adjacent.contains(n1)) {
                        n2.adjacent.add(n1);
                    }
                }
            }
        }

        // dfs
        for (int i = 0; i < nodes.length; i++) {
            Node root = nodes[i];
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            if (!root.marked) {
                answer++;
                root.marked = true;
            }
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                for (Node node : r.adjacent) {
                    if (node.marked == false) {
                        node.marked = true;
                        stack.push(node);
                    }
                }
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        네트워크 n = new 네트워크();
        System.out.println(n.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(n.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));

    }
}
