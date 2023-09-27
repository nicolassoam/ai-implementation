import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;
import java.util.Deque;

public class DepthSearch {
    private Node root;
    private Stack<Node> openStack;
    private Stack<Node> closedStack;
    // private Set<Node> visited;
    private Deque<Integer> strategy;
    private Rules rules;

    public DepthSearch(Deque<Integer> strategy) {
        this.root = new Node();
        this.openStack = new Stack<Node>();
        this.closedStack = new Stack<Node>();
        // this.visited = new HashSet<Node>();
        this.strategy = strategy;
        this.openStack.push(root);
        this.rules = new Rules();
    }

    public void DFS() {
        while(!this.openStack.isEmpty()) {
            Node node = this.openStack.pop();

            for (int s : strategy) {
                Bucket[] aux_ = this.rules.applyRule(node.copyBuckets(), s);

                if(aux_ != null) {
                    Node aux = new Node();
                    aux.setBuckets(aux_);
                    boolean flag = false;
                    for (Node n : closedStack) {
                        if(n.getBuckets()[0].getAmount() == aux.getBuckets()[0].getAmount() && n.getBuckets()[1].getAmount() == aux.getBuckets()[1].getAmount()) {
                            aux = null;
                            flag = true;
                            break;
                        }
                    }
                    if(flag) continue;
                    node.getChildrens().add(aux);
                    this.openStack.push(aux);
                }
            }

            System.out.println(node);
            if(node.getSumBuckets() == 4 || node.getSumBuckets() == 7) {
                System.out.println("Solução encontrada");
                break;
            }
            this.closedStack.push(node);
        }

        
    }

    private Boolean validateRule(Bucket[] buckets, int index){
        buckets = this.rules.applyRule(buckets, index);
        if(buckets == null) return false;
        return true;
    }
}
