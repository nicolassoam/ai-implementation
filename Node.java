import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> childrens;
    private Bucket[] buckets;

    public Node() {
        childrens = new ArrayList<Node>();
        buckets = new Bucket[2];
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