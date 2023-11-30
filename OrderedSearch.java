import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.lang.Math;

public class OrderedSearch {
    private Path path;
    Map<String, Boolean> nodeMap = new HashMap<>();
    PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

    public OrderedSearch() {
        
    }

    private int getShiftedWater(Bucket[] a0, Bucket[] a2, int rule) {
        int shifted1 = Math.abs(a0[0].getAmount() - a2[0].getAmount());
        int shifted2 = Math.abs(a0[1].getAmount() - a2[1].getAmount());
        return rule == 5 || rule == 6 ? (shifted1 + shifted2) / 2 : shifted1 + shifted2 ;
    }

    public Node exec(Node initialCondition, List<Integer> rulesOrder) throws InterruptedException {
        Rules rules = new Rules();
        Bucket[] current = initialCondition.getBuckets();
        if (!nodeMap.containsKey(initialCondition.getHash())) {
            nodeMap.put(initialCondition.getHash(), true);
        }
        //System.out.println("Start executing ordered search");

        for(int rule : rulesOrder) {
            Bucket[] buckets = rules.applyRule(current, rule);
            if(buckets != null) {
                Node nNode = new Node();
                nNode.setBuckets(buckets);
                nNode.setFather(initialCondition);
                if (!nodeMap.containsKey(nNode.getHash())) {
                    if(Node.getItsSolution(buckets)) return nNode;
                    int shifted = getShiftedWater(initialCondition.getBuckets(), nNode.getBuckets(), rule);
                    nNode.setShiftedWater(shifted);
                    nodeMap.put(nNode.getHash(), true);
                    priorityQueue.add(nNode);
                }
            }
        }
        return exec(priorityQueue.poll(), rulesOrder);
    }
}
