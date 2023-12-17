public class Rules {

    // Enche balde de 5 litros
    public Bucket[] R1(Bucket[] buckets, int from, int to) {
        if(buckets[0].getAmount() == 5) return null;
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
        _Buckets[0].setAmount(5);
        _Buckets[0].setLimit(5);
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        return _Buckets;
    }

    // Enche balde de 3 litros
    public Bucket[] R2(Bucket[] buckets, int from, int to) {
        if(buckets[1].getAmount() == 3) return null;
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
        _Buckets[1].setAmount(3);
        _Buckets[1].setLimit(3);
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        return _Buckets;
    }

    // Esvazia balde de 5 litros
    public Bucket[] R3(Bucket[] buckets, int from, int to) {
        if(buckets[0].getAmount() == 0) return null;
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
        _Buckets[0].setAmount(0);
        _Buckets[0].setLimit(5);
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());
        return _Buckets;
    }

    // Esvaiza balde de 3 litros
    public Bucket[] R4(Bucket[] buckets, int from, int to) {
        if(buckets[1].getAmount() == 0) return null;
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
        _Buckets[1].setAmount(0);
        _Buckets[1].setLimit(3);
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        return _Buckets;
    }

    // Passa água do balde de 3 litros para o de 5 litros
    public Bucket[] R5(Bucket[] buckets, int from, int to) {
        if(buckets[1].getAmount() == 0) {
            return null;
        }
        if(buckets[0].getAmount() == 5) {
            return null;
        }
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
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

        if(_Buckets[0].getAmount() < 0 || _Buckets[1].getAmount() < 0) return null;

        return _Buckets;
    }

    // Passa água do balde de 5 litros para o de 3 litros
    public Bucket[] R6(Bucket[] buckets, int from, int to) {
        if(buckets[1].getAmount() == 3) return null;
        if(buckets[0].getAmount() == 0) return null;
        Bucket[] _Buckets = new Bucket[2];
        _Buckets[0] = new Bucket();
        _Buckets[1] = new Bucket();
        _Buckets[0].setAmount(buckets[0].getAmount());
        _Buckets[0].setLimit(buckets[0].getLimit());
        _Buckets[1].setAmount(buckets[1].getAmount());
        _Buckets[1].setLimit(buckets[1].getLimit());

        int amount = _Buckets[0].getAmount() + _Buckets[1].getAmount();
        if(_Buckets[0].getAmount() + _Buckets[1].getAmount() > _Buckets[1].getLimit()) {
            _Buckets[1].setAmount(3);
            _Buckets[0].setAmount(amount - _Buckets[1].getLimit());
        }
        else {
            _Buckets[1].setAmount(amount);
            _Buckets[0].setAmount(0);
        }

        return _Buckets;
    }

    /**
     * @param buckets
     * @param index Começa em 1 e vai até n(numero de regras)
     * @return
     */
    public Bucket[] applyRule(Bucket[] buckets, int index) {
        switch(index) {
            case 1:
                return this.R1(buckets, index, index);
            case 2:
                return this.R2(buckets, index, index);
            case 3:
                return this.R3(buckets, index, index);
            case 4:
                return this.R4(buckets, index, index);
            case 5:
                return this.R5(buckets, index, index);
            case 6:
                return this.R6(buckets, index, index);
            
            default:
                return null;
        }
    }

}
