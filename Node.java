import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Node {
    private List<Node> childrens;
    private Bucket[] buckets;
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

}