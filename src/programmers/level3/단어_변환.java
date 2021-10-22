package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환
 * 문제 설명
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
 * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
 *
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
 * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 * 입출력 예
 * begin	target	words	return
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
 * "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
 * 입출력 예 설명
 * 예제 #1
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 * target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.
 */
public class 단어_변환 {
    static class Node {
        String data;
        LinkedList<Node> adjacent;
        int history = 0;
        boolean marked;

        Node(String data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }

    Node[] nodes;
    Node answerNode = new Node("data");

    public int solution(String begin, String target, String[] words) {

        boolean inThereTarget = false;

        nodes = new Node[words.length + 1];
        nodes[0] = new Node(begin);
        // 노드들 초기화
        for (int i = 0; i < words.length; i++) {
            nodes[i + 1] = new Node(words[i]);
        }

        // 노드간 관계 정리
        for (int i = 0; i < nodes.length; i++) {

            for (int j = i + 1; j < nodes.length; j++) {

                // 값이 하나라도 같은 것이 있다면
                if (addEdge(nodes[i].data, nodes[j].data)) {
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

        // 최단거리 구하기 -> bfs
        Node root = nodes[0];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {

            Node r = queue.poll();

            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                    n.history = r.history + 1;
                }
            }

            // target 과 같은지 비교
            if (target.equals(r.data)) {
                inThereTarget = true;
                answerNode = r;
                break;
            }
        }

        if (inThereTarget) {
            return answerNode.history;
        }

        return 0;
    }

    public boolean addEdge(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int count = 0;

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
        }

        return count == 1;
    }

    public static void main(String[] args) {
        // "hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]

        단어_변환 clazz = new 단어_변환();
        System.out.println(clazz.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
