public interface Rule {
    public Bucket[] applyRule(Bucket[] buckets, int from, int to);
    public boolean verifyRule(Bucket[] buckets, int from, int to);
}