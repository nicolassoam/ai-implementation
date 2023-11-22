import java.util.Stack;
import java.util.Deque;

public class DepthSearch {
    private Node root;
    private Stack<Node> openStack;
    private Stack<Node> closedStack;
    // private Set<Node> visited;
    private Deque<Integer> strategy;
    private int pointer;
    private Rules rules;

    /*
     * @param strategy: Estratégia de busca
     */
    public DepthSearch(Deque<Integer> strategy) {
        this.root = new Node();
        
        this.openStack = new Stack<Node>();
        this.closedStack = new Stack<Node>();
        // this.visited = new HashSet<Node>();
        this.pointer = 1;
        this.strategy = strategy;
        this.root.setId(pointer);
        this.openStack.push(root);
        this.rules = new Rules();
    }

    public void DFS() {
        while(!this.openStack.isEmpty()) {
            Node node = this.openStack.pop();
            // System.out.println("Nó visitado: " + node.getId());
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

                    for(Node n :openStack){
                        if(n.getBuckets()[0].getAmount() == aux.getBuckets()[0].getAmount() && n.getBuckets()[1].getAmount() == aux.getBuckets()[1].getAmount()) {
                            aux = null;
                            flag = true;
                            break;
                        }
                    }
                    
                    if(flag) continue;

                    this.pointer = this.pointer + 1;

                    aux.setId(this.pointer);

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

    @SuppressWarnings("unused")
    private void printSolution(Node node){
        if(node.getChildrens().size() == 0) return;
        System.out.println(node);

        for (Node n : node.getChildrens()) {
            printSolution(n);
        }
    }

    @SuppressWarnings("unused")
    private Boolean validateRule(Bucket[] buckets, int index){
        buckets = this.rules.applyRule(buckets, index);
        if(buckets == null) return false;
        return true;
    }
}
