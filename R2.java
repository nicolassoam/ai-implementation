public class R2 implements Rule {
    
    public R2() {
        
    }


    @Override
    public Bucket[] applyRule(Bucket[] buckets, int from, int to) {
        Bucket[] _Buckets = buckets;
        _Buckets[1].setAmount(3);
        _Buckets[1].setLimit(3);
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        return _Buckets;
    }

    @Override
    public boolean verifyRule(Bucket[] buckets, int from, int to) {
        return buckets[1].getAmount() < 3;
    }
    
}
