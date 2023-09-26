import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

public class DepthSearch {
    private Node root;
    private Stack<Node> openStack;
    private Stack<Node> closedStack;
    private List<Integer> strategy;
    private Rules rules;

    public DepthSearch(List<Integer> strategy) {
        this.root = new Node();
        this.openStack = new Stack<Node>();
        this.closedStack = new Stack<Node>();
        this.strategy = strategy;
        this.openStack.push(root);
        this.rules = new Rules();
    }

    public void DFS() {
        while(!this.openStack.isEmpty()) {
            Node node = this.openStack.pop();
            // System.out.println(node);
            if(node.getSumBuckets() == 4 || node.getSumBuckets() == 7) {
                System.out.println("Solução encontrada");
                break;
            }
            
            for (Integer s : this.strategy) {
                Bucket[] aux_ = new Bucket[2];
                aux_ = node.getBuckets();
                aux_ = this.rules.applyRule(aux_, s);

                if(aux_ == null) continue;

                // System.out.println(aux_[0].getAmount() + " " + aux_[1].getAmount());
                boolean flag = false;
                for (Node n : this.closedStack) {
                    if(n.getBuckets()[0].getAmount() == aux_[0].getAmount() && n.getBuckets()[1].getAmount() == aux_[1].getAmount()) {
                        flag = true;
                        break;
                    }
                }
                
                if(flag) continue;
                System.out.println(aux_[0].getAmount() + " " + aux_[1].getAmount());
                Node aux = new Node();
                aux.setBuckets(aux_);
                node.getChildrens().add(aux);
                this.openStack.push(aux);
                
            }
            this.closedStack.push(node);
        }
    }
}
