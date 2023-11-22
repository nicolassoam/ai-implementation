import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class BreadthSearch {
    private Node root;
    private Queue<Node> openQueue;
    private Queue<Node> closedQueue;
    private Deque<Integer> strategy;
    private int pointer;
    private Rules rules;

    /*
     * @param strategy: Estratégia de busca
     */
    public BreadthSearch(Deque<Integer> strategy) {
        this.root = new Node();

        this.openQueue = new LinkedList<>();
        this.closedQueue = new LinkedList<>();
        this.pointer = 1;
        this.strategy = strategy;
        this.root.setId(pointer);
        this.openQueue.add(root);
        this.rules = new Rules();
    }

    public void BFS() {
        while(!this.openQueue.isEmpty()) {
            Node node = this.openQueue.remove();

            for (int s : strategy) {
                Bucket[] aux_ = this.rules.applyRule(node.copyBuckets(), s);

                if(aux_ != null) {
                    System.out.println("Regra " + s + " pode ser aplicada");
                    Node aux = new Node();

                    aux.setBuckets(aux_);

                    boolean flag = false;
                    for (Node n : closedQueue) {
                        if (n.getBuckets()[0].getAmount() == aux.getBuckets()[0].getAmount() && n.getBuckets()[1].getAmount() == aux.getBuckets()[1].getAmount()) {
                            aux = null;
                            flag = true;
                            break;
                        }
                    }

                    if (flag) continue;

                    this.pointer = this.pointer + 1;

                    aux.setId(this.pointer);

                    node.getChildrens().add(aux);

                    this.openQueue.add(aux);
                }
            }

            System.out.println(node);
            if(node.getSumBuckets() == 4 || node.getSumBuckets() == 7) {
                System.out.println("Solução encontrada");
                break;
            }

            this.closedQueue.add(node);
        }
    }
}
