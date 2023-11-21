import java.util.Objects;

public class Bucket {
    private int limit;
    private int amount;



    public Bucket(int limit, int amount) {
        this.limit = limit;
        this.amount = amount;
    }

    public Bucket() {
        
    }

    @Override
    public String toString() {
        return "Bucket{limit=" + limit + ", amount=" + amount + "}";
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public static boolean validateRule(Bucket[] buckets, int rule) {
        
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return limit == bucket.limit && amount == bucket.amount;
    }

    public Bucket(Bucket other) {
        this.limit = other.limit;
        this.amount = other.amount;
    }

    // Método de clone
    public Bucket clone() {
        return new Bucket(this);
    }
}
