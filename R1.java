public class R1 implements Rule {

    public R1() {
        
    }

    @Override
    public Bucket[] applyRule(Bucket[] buckets, int from, int to) {
        Bucket[] _Buckets = buckets;
        _Buckets[0].setAmount(5);
        _Buckets[0].setLimit(5);
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        return _Buckets;
    }

    @Override
    public boolean verifyRule(Bucket[] buckets, int from, int to) {
        return buckets[0].getAmount() < 5;
    }

    
}
