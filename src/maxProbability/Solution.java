package maxProbability;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        // TODO �Զ����ɵķ������

        int n = 3, start = 0, end = 2;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        System.out.println(new Solution().maxProbability(n, edges, succProb, start, end));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        @SuppressWarnings("unchecked")
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            // ����ͼ����˫��ͼ���Ȱ� int ͳһת�� double��������ת����
            graph[from].add(new double[] { to, weight });
            graph[to].add(new double[] { from, weight });
        }
        return dijkstra(start, end, graph);
    }

    class State {
        // ͼ�ڵ�� id
        int id;
        // �� start �ڵ㵽�ﵱǰ�ڵ�ĸ���
        double probFromStart;

        State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    double dijkstra(int start, int end, List<double[]>[] graph) {
        // ���壺probTo[i] ��ֵ���ǽڵ� start ����ڵ� i ��������
        double[] probTo = new double[graph.length];
        // dp table ��ʼ��Ϊһ��ȡ��������Сֵ
        Arrays.fill(probTo, -1);
        // base case��start �� start �ĸ��ʾ��� 1
        probTo[start] = 1;

        Queue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));
        pq.offer(new State(start, 1));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            double curProbFromStart = curState.probFromStart;

            if (curNodeID == end) {
                return curProbFromStart;
            }
            if (curProbFromStart < probTo[curNodeID]) {
                // �Ѿ���һ�����ʸ����·������ curNode �ڵ���
                continue;
            }
            for (double[] neighbor : graph[curNodeID]) {
                int nextNodeID = (int) neighbor[0];
                // ������ curNode �ﵽ nextNode �ĸ����Ƿ�����
                double probToNextNode = probTo[curNodeID] * neighbor[1];
                if (probTo[nextNodeID] < probToNextNode) {
                    probTo[nextNodeID] = probToNextNode;
                    pq.offer(new State(nextNodeID, probToNextNode));
                }
            }
        }
        // ����������˵���� start ��ʼ�޷����� end������ 0
        return 0.0;
    }
}
