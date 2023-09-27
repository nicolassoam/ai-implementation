import java.util.ArrayList;
import java.util.List;


public class Node {
    private List<Node> childrens;
    private Bucket[] buckets;
    private int id;

    public Node() {
        childrens = new ArrayList<Node>();
        buckets = new Bucket[2];
        buckets[0] = new Bucket(5, 0);
        buckets[1] = new Bucket(3, 0);
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

    public void setBuckets(Bucket[] buckets) {
        this.buckets = buckets;
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

}