public class Rules {
    private Rule[] rules;

    public Rules() {
        rules = new Rule[6];
        rules[0] = new R1();
        rules[1] = new R2();
        rules[2] = new R3();
        rules[3] = new R4();
        rules[4] = new R5();
        rules[5] = new R6();
    }

    /**
     * @param buckets
     * @param index Começa em 1 e vai até n(numero de regras)
     * @return
     */
    public Bucket[] applyRule(Bucket[] buckets, int index) {
        if(!rules[index - 1].verifyRule(buckets, index, index)) {
            return null;
        }

        return rules[index-1].applyRule(buckets, index, index);
    }
}
