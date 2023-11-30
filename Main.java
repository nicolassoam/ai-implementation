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

        List<Integer> order = new ArrayList<>();
        order.add(6);
        order.add(5);
        order.add(4);
        order.add(3);
        order.add(1);
        order.add(2);

        Node nNode = new AStarSearch().exec(initialCondition, order);
        Bucket[] nBuckets = nNode.getBuckets();


        System.out.print("FINAL SOLUTION: [");
        System.out.print(nBuckets[0].toString());
        System.out.print(" " + nBuckets[1].toString());
        System.out.println("]");
    }    
}
