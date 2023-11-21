import java.util.ArrayList;
import java.util.List;

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
    }    
}
