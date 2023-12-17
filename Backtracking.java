import java.util.Stack;
import java.util.List;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Backtracking {
    Map<String, Boolean> nodeMap = new HashMap<>();
    public int iterations = 0;
    public Node solution = null;

    public Node getSolution() {
        return solution;
    }

    public void setSolution(Node solution) {
        this.solution = solution;
    }

    public Backtracking() {

    }

    public void exec(Node initialCondition, Deque<Integer> rulesOrder) throws InterruptedException {
        Rules rules = new Rules();
        Bucket[] current = initialCondition.getBuckets();
        if (!nodeMap.containsKey(initialCondition.getHash())) {
            nodeMap.put(initialCondition.getHash(), true);
        }
    
        for (int rule : rulesOrder) {
            System.out.println("Applying rule " + rule + " in buckets: (" + current[0].getAmount() + "," + current[1].getAmount() + ")");
            if(solution != null) return;
            // Adiciona Thread.sleep dentro do loop
            Thread.sleep(500);  // Pausa de 5 segundos
    
            Bucket[] target = rules.applyRule(initialCondition.getBuckets().clone(), rule);
            if (Node.getItsSolution(target)) {
                solution = new Node();
                solution.setBuckets(target);
                return;
            }
                
            Node nNode = new Node();
            if (target != null) {
                nNode.setBuckets(target.clone());
    
                if (!nodeMap.containsKey(nNode.getHash())) {
                    System.out.print("[");
                    System.out.print(nNode.getBuckets()[0].getAmount() + ",");
                    System.out.print(nNode.getBuckets()[1].getAmount());
                    System.out.println("]");
                    this.exec(nNode, rulesOrder);
                }
            } else {
                continue;
            }
        }

    }
    
}
