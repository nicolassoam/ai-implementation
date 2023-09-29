

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando execução");
        Bucket[] buckets = new Bucket[2];
        buckets[0] = new Bucket(5, 0);
        buckets[1] = new Bucket(3, 0);
        Rules rule = new Rules();
        rule.applyRule(buckets, 1);

        for(int i = 0; i < 2; i++) {
            System.out.println(buckets[i]);
        }

        rule.applyRule(buckets, 2);

        for(int i = 0; i < 2; i++) {
            System.out.println(buckets[i]);
        }
    }    
}
