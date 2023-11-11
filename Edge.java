public class Edge {
    private int sourceId;
    private int targetId;
    private int cost;

    Edge(int sourceId, int targetId, int cost){
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.cost = cost;
    }

    Edge(int sourceId, int targetId){
        this.sourceId = sourceId;
        this.targetId = targetId;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getSourceId() {
        return sourceId;
    }
    public int getTargetId() {
        return targetId;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}