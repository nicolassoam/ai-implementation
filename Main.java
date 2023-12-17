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
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // Breadth Search
        System.out.println("------------------");
        System.out.println("Busca em Largura");
        start = System.currentTimeMillis();
        BreadthSearch breadthSearch = new BreadthSearch(strategy);
        breadthSearch.BFS();
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // Depth Search
        System.out.println("------------------");
        System.out.println("Busca em Profundidade");
        start = System.currentTimeMillis();
        DepthSearch depthSearch = new DepthSearch(strategy);
        depthSearch.DFS();
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // Ordered Search
        System.out.println("------------------");
        System.out.println("Busca Ordenada");
        start = System.currentTimeMillis();
        Node nNode = new OrderedSearch().exec(initialCondition, strategy);
        Bucket[] nBuckets = nNode.getBuckets();
        System.out.print("SOLUÇÃO FINAL: [");
        System.out.print(nBuckets[0].toString());
        System.out.print(" | " + nBuckets[1].toString());
        System.out.println("]");
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

        // A* Search
        System.out.println("------------------");
        System.out.println("Busca A*");
        start = System.currentTimeMillis();
        Node aNode = new AStarSearch().exec(initialCondition, strategy);
        Bucket[] aBuckets = aNode.getBuckets();
        System.out.print("SOLUÇÃO FINAL: [");
        System.out.print(aBuckets[0].toString());
        System.out.print(" | " + aBuckets[1].toString());
        System.out.println("]");
        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");
    }    
}
