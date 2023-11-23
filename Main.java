import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando execução");
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
    }    
}
