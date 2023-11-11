import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando execução");
        Deque<Integer> strategy = new ArrayDeque<Integer>();

        for (int i = 6; i >= 1; i--) {
            strategy.push(i);
            // System.out.println("Estratégia " + i);
        }
        double start = System.currentTimeMillis();
        GreedySearch greedySearch = new GreedySearch(strategy);
        greedySearch.greedy();
        double end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");
    }    
}
