import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> childrens;
    private Bucket[] buckets;

    public Node() {
        childrens = new ArrayList<Node>();
        buckets = new Bucket[2];
        buckets[0] = new Bucket(5, 0);
        buckets[1] = new Bucket(3, 0);
    }

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setBuckets(Bucket[] buckets) {
        this.buckets = buckets;
    }

    @Override
    public String toString() {
        return "Node {buckets=" + buckets[0].getAmount() + " " + buckets[1].getAmount() + "}";
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

}