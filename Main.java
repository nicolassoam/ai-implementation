import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner menu = new Scanner(System.in);

        System.out.println("MÉTODOS INFORMADOS E NÃO INFORMADOS");
        System.out.println("-------------------------------------");
        System.out.println("[1] Backtracking");
        System.out.println("[2] Busca em largura");
        System.out.println("[3] Busca em profundidade");
        System.out.println("[4] Busca ordenada");
        System.out.println("[5] Busca gulosa");
        System.out.println("[6] Busca A*");
        System.out.println("-------------------------------------");
        System.out.println("Escolha o método de busca:");

        int opcao = menu.nextInt();

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

        System.out.println("-------------------------------------");
        System.out.println("Iniciando execução");

        start = System.currentTimeMillis();

        switch (opcao) {
            case 1:
                // Backtracking
                System.out.println("-------------------------------------");
                System.out.println("Backtracking");
                Backtracking bk = new Backtracking();
                bk.exec(initialCondition, strategy);
                Node solution = bk.getSolution();
                break;
            case 2:
                // Breadth Search
                System.out.println("-------------------------------------");
                System.out.println("Busca em Largura");
                BreadthSearch breadthSearch = new BreadthSearch(strategy);
                breadthSearch.BFS();
                break;
            case 3:
                // Depth Search
                System.out.println("-------------------------------------");
                System.out.println("Busca em Profundidade");
                DepthSearch depthSearch = new DepthSearch(strategy);
                depthSearch.DFS();
                break;
            case 4:
                // Ordered Search
                System.out.println("-------------------------------------");
                System.out.println("Busca Ordenada");
                Node nNode = new OrderedSearch().exec(initialCondition, strategy);
                Bucket[] nBuckets = nNode.getBuckets();
                System.out.print("SOLUÇÃO FINAL: [");
                System.out.print(nBuckets[0].toString());
                System.out.print(" | " + nBuckets[1].toString());
                System.out.println("]");
                break;
            case 5:
                // Greedy Search
                System.out.println("-------------------------------------");
                System.out.println("Busca Gulosa");
                GreedySearch greedySearch = new GreedySearch(strategy);
                greedySearch.greedy();
                break;
            case 6:
                // A* Search
                System.out.println("-------------------------------------");
                System.out.println("Busca A*");
                Node aNode = new AStarSearch().exec(initialCondition, strategy);
                Bucket[] aBuckets = aNode.getBuckets();
                System.out.print("SOLUÇÃO FINAL: [");
                System.out.print(aBuckets[0].toString());
                System.out.print(" | " + aBuckets[1].toString());
                System.out.println("]");
                break;
            default:
                break;
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo de execução: " + (end - start) + "ms");

    }    
}
