import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Node implements Comparable<Node> {
    private List<Node> childrens;
    private Bucket[] buckets;
    private int shiftedWater = 0;
    private Node father = null;
    private double heuristic;
    private double evaluation;
    private int pathCost = 0;

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public int getShiftedWater() {
        return shiftedWater;
    }

    public void setPathCost(int pathCost) { this.pathCost = pathCost + getShiftedWater(); }

    public int getPathCost() { return this.pathCost; }

    public void setShiftedWater(int shiftedWater) {
        this.shiftedWater = shiftedWater;
    }

    public void calculateHeuristic() {
        int sumBuckets = this.getBuckets()[0].getAmount() + this.getBuckets()[1].getAmount();

        if(sumBuckets == 7 || sumBuckets == 4)
            this.heuristic = 0;
        else
            this.heuristic = Math.pow((7-sumBuckets),2) + Math.pow((4-sumBuckets), 2);
    }
    public double getHeuristic() { return this.heuristic; }

    public void setHeuristic(double heuristic) { this.heuristic = heuristic; }
    public double getEvaluation() { return this.evaluation; }

    public void setBuckets(Bucket[] buckets) {
        this.buckets = buckets;
    }

    private static final AtomicInteger ids = new AtomicInteger(0);
    private int id;
    private int depth;

    public Node() {

        this.childrens = new ArrayList<Node>();
        this.buckets = new Bucket[2];
        this.buckets[0] = new Bucket(5, 0);
        this.buckets[1] = new Bucket(3, 0);
        this.depth = 0;
        this.father = null;
        this.id = ids.incrementAndGet();

    }

    public void setId(int id){
        this.id = id;
        return;
    }

    public List<Node> getChildrens() {
        return childrens;
    }     

    public Bucket[] copyBuckets(){
        Bucket[] _Buckets = new Bucket[2];
        
        _Buckets[0] = new Bucket(5, 0);
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        _Buckets[1] = new Bucket(3, 0);
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        return _Buckets;
    }

    @Override
    public String toString() {
        return "Node {id = " +this.id +" buckets = " + buckets[0].getAmount() + " " + buckets[1].getAmount() + "}";
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }
    public int getSumBuckets() {
        return buckets[0].getAmount() + buckets[1].getAmount();
    }
    public Bucket[] getBuckets() {
        return buckets;
    }

    public static boolean getItsSolution(Bucket[] buckets) {
        if(buckets == null) return false;
        return buckets[0].getAmount() + buckets[1].getAmount() == 4 || buckets[0].getAmount() + buckets[1].getAmount() == 7;
    }

    public void evaluate() {
        this.evaluation = getHeuristic() + getPathCost();
        System.out.println("ID " + getId() + " | " + getBuckets()[0].toString() + " | " + getBuckets()[1].toString());
        System.out.println("f(n): " + getEvaluation() + " = " + getHeuristic() + " + " + getPathCost() + "\n");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(buckets);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node other = (Node) obj;
        return Arrays.equals(buckets, other.buckets);
    }

    public String getHash() {
        String result = buckets[0].getAmount() + "," + buckets[1].getAmount();
        return result;
    }

   public int getId() {
       return id;
   }

   public void setDepth(int depth) {
       this.depth = depth;
   }

   public int getDepth() {
       return depth;
   }

    @Override
    public int compareTo(Node arg0) {
        return this.shiftedWater - arg0.shiftedWater;
    }
}