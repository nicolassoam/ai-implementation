import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Node {
    private List<Node> childrens;
    private Bucket[] buckets;
    private static final AtomicInteger ids = new AtomicInteger(0);
    private int id;
    private double heuristic;

    public Node() {
        this.childrens = new ArrayList<Node>();
        this.buckets = new Bucket[2];
        this.id = ids.incrementAndGet();
        buckets[0] = new Bucket(5, 0);
        buckets[1] = new Bucket(3, 0);
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

    public int getSumBuckets() {
        return buckets[0].getAmount() + buckets[1].getAmount();
    }

    @Override
    public String toString() {
        return "Node {id = " +this.id +" buckets = " + buckets[0].getAmount() + " " + buckets[1].getAmount() + "}" + " " + "heuristic = " + heuristic;
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

    public int getId() {
        return id;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public void setBuckets(Bucket[] buckets) {
        this.buckets = buckets;
    }
    public double getHeuristic() {
        return heuristic;
    }
}