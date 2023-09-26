import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando execução");
        List<Integer> strategy = new ArrayList<Integer>();

        for (int i = 1; i <= 6; i++) {
            strategy.add(i);
            // System.out.println("Estratégia " + i);
        }

        DepthSearch depthSearch = new DepthSearch(strategy);
        depthSearch.DFS();

    }    
}
