public class R5 implements Rule {

    public R5() {
        
    }

    @Override
    public Bucket[] applyRule(Bucket[] buckets, int from, int to) {
        Bucket[] _Buckets = buckets;
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        int amount = _Buckets[0].getAmount() + _Buckets[1].getAmount();
        if(_Buckets[0].getAmount() + _Buckets[1].getAmount() > _Buckets[0].getLimit()) {
            _Buckets[0].setAmount(5);
            _Buckets[1].setAmount(amount - _Buckets[0].getLimit());
        }
        else {
            _Buckets[0].setAmount(amount);
            _Buckets[1].setAmount(0);
        }
        return _Buckets;
    }

    @Override
    public boolean verifyRule(Bucket[] buckets, int from, int to) {
        return buckets[0].getAmount() < 5 && buckets[1].getAmount() > 0;
    }
    
}
