public class Bucket {
    private int limit;
    private int amount;



    public Bucket(int limit, int amount) {
        this.limit = limit;
        this.amount = amount;
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
}
