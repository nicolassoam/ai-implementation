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

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public int getShiftedWater() {
        return shiftedWater;
    }

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
    public double getEvaluation() { return this.evaluation; }

    public void setBuckets(Bucket[] buckets) {
        this.buckets = buckets;
    }

    private static final AtomicInteger ids = new AtomicInteger(0);
    private int id;

    public Node() {
        this.childrens = new ArrayList<Node>();
        this.buckets = new Bucket[2];
        this.id = ids.incrementAndGet();
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }

    public Bucket[] getBuckets() {
        return buckets;
    }

    public static boolean getItsSolution(Bucket[] buckets) {
        if(buckets == null) return false;
        return buckets[0].getAmount() + buckets[1].getAmount() == 4 || buckets[0].getAmount() + buckets[1].getAmount() == 7;
    }

    public void evaluate() {
        this.evaluation = getHeuristic() + getShiftedWater();
        System.out.println(getBuckets()[0].toString() + " " + getBuckets()[1].toString());
        System.out.println("f(n): " + getEvaluation() + " = " + getHeuristic() + " + " + getShiftedWater());
    }

    @Override
    public String toString() {
        String str = new String();
        str.concat("[");
        str = str.concat(this.buckets[0].toString());
        str = str.concat("\n");
        str = str.concat(this.buckets[1].toString());
        str.concat("]");
        return str;
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

    @Override
    public int compareTo(Node arg0) {
        return this.shiftedWater - arg0.shiftedWater;
    }

}