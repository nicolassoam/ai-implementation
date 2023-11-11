import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class GreedySearch {
    private Node root;
    private List<Edge> edges;
    private Rules rules;
    private PriorityQueue<Node> openList;
    private List<Node> closedList;
    private Deque<Integer> strategy;

    private double heuristic(int cost){
        return Math.pow((7-cost),2) + Math.pow((4-cost), 2);
    }

    public GreedySearch(Deque<Integer> strategy){
        this.root = new Node();
        this.edges = new ArrayList<Edge>();
        this.rules = new Rules();
        this.openList = new PriorityQueue<Node>(Comparator.comparing(Node::getHeuristic));
        this.closedList = new ArrayList<Node>();
        root.setHeuristic(heuristic(root.getSumBuckets()));
        this.openList.add(root);
        this.strategy = strategy;
    }

    private int calculateAmountChanged(Bucket[] buckets, int i){
        int amountChanged = 0;
        //r1 r2 r3 r4 r5 r6
        switch (i) {
            case 1:
                amountChanged = buckets[0].getLimit();
                break;
            case 2:
                amountChanged = buckets[1].getLimit();
                break;
            case 3:
                amountChanged = buckets[0].getLimit();
                break;
            case 4:
                amountChanged = buckets[1].getLimit();
                break;
            case 5:
                if(buckets[0].getAmount() + buckets[1].getAmount() > buckets[0].getLimit())
                    amountChanged = buckets[0].getLimit() - buckets[0].getAmount();
                else
                    amountChanged = buckets[1].getAmount();
                break;
            case 6:
                amountChanged = buckets[0].getAmount() + buckets[1].getAmount() > buckets[1].getLimit() ? buckets[1].getLimit() - buckets[1].getAmount() : buckets[0].getAmount();
                break;
            default:
                break;
        }
        return amountChanged;
    }

    public void greedy(){
        while(!this.openList.isEmpty()){
            Node actualState = this.openList.remove();

            for (int i : strategy) {
                Bucket[] aux_ = this.rules.applyRule(actualState.copyBuckets(), i);
                int edgeCost = calculateAmountChanged(actualState.getBuckets(), i);

                if(aux_ != null){
                    Node aux = new Node();
                    aux.setBuckets(aux_);
                    aux.setHeuristic(heuristic(aux.getSumBuckets()));

                    boolean flag = false;
                    for (Node n : closedList) {
                        if(n.getBuckets()[0].getAmount() == aux.getBuckets()[0].getAmount() && n.getBuckets()[1].getAmount() == aux.getBuckets()[1].getAmount()) {
                            aux = null;
                            flag = true;
                            break;
                        }
                    }
                    
                    if(flag) continue;

                    Edge edge = new Edge(actualState.getId(), aux.getId(), edgeCost);
                    edges.add(edge);
                    actualState.getChildrens().add(aux);
                    this.openList.add(aux);
                }


            }

            System.out.println(actualState);

            if(actualState.getSumBuckets() == 4 || actualState.getSumBuckets() == 7){
                System.out.println("Solução encontrada: " + actualState);
                break;
            }
            this.closedList.add(actualState);
        }
    }
}
