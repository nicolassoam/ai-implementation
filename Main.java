import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando execução");
        Bucket[] buckets = new Bucket[2];
        buckets[0] = new Bucket(5, 0);
        buckets[1] = new Bucket(3, 0);
        Node initialCondition = new Node();
        initialCondition.setBuckets(buckets);
        Backtracking bk = new Backtracking();
        List<Integer> order = new ArrayList<>();
        order.add(6);
        order.add(5);
        order.add(4);
        order.add(3);
        order.add(1);
        order.add(2);
        bk.exec(initialCondition, order);
        Node solution = bk.getSolution();
        System.out.print("[");
        System.out.print(solution.getBuckets()[0].getAmount() + ",");
        System.out.print(solution.getBuckets()[1].getAmount());
        System.out.println("]");
        Deque<Integer> strategy = new ArrayDeque<Integer>();

        for (int i = 1; i <= 6; i++) {
            strategy.push(i);
            // System.out.println("Estratégia " + i);
        }
        double start = System.currentTimeMillis();
        BreadthSearch breadthSearch = new BreadthSearch(strategy);
        breadthSearch.BFS();
        double end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        DepthSearch depthSearch = new DepthSearch(strategy);
        depthSearch.DFS();
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");
    }    
}
