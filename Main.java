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

        Deque<Integer> strategy = new ArrayDeque<Integer>();
        for (int i = 1; i <= 6; i++) {
            strategy.push(i);
        }

        double start, end;

        // Backtracking
        System.out.println("------------------");
        System.out.println("Backtracking");
        start = System.currentTimeMillis();
        Backtracking bk = new Backtracking();
        bk.exec(initialCondition, strategy);
        Node solution = bk.getSolution();
        System.out.print("[");
        System.out.print(solution.getBuckets()[0].getAmount() + ",");
        System.out.print(solution.getBuckets()[1].getAmount());
        System.out.println("]");
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // Breadth Search
        System.out.println("------------------");
        System.out.println("Breadth Search");
        start = System.currentTimeMillis();
        BreadthSearch breadthSearch = new BreadthSearch(strategy);
        breadthSearch.BFS();
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // Depth Search
        System.out.println("------------------");
        System.out.println("Depth Search");
        start = System.currentTimeMillis();
        DepthSearch depthSearch = new DepthSearch(strategy);
        depthSearch.DFS();
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");
    }    
}
