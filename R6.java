public class R6 implements Rule {

    public R6() {
        
    }

    @Override
    public Bucket[] applyRule(Bucket[] buckets, int from, int to) {
        Bucket[] _Buckets = buckets;
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        int maxAmount = _Buckets[1].getLimit() - _Buckets[1].getAmount();
        _Buckets[1].setAmount(maxAmount + _Buckets[1].getAmount());
        _Buckets[0].setAmount(_Buckets[0].getAmount() - maxAmount);
        return _Buckets;
    }

    @Override
    public boolean verifyRule(Bucket[] buckets, int from, int to) {
        return buckets[1].getAmount() < 3 && buckets[0].getAmount() > 0;
    }
    
}
