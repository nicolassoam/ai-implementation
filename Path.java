import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<Node> path;

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public Path() {
        path = new ArrayList<>();
    }

    public void addPathTermination(Node pathItem) {
        path.add(pathItem);
    }

    @Override
    public String toString() {
        String result = "";
        result = result.concat("Caminho solução");
        for(int index = 0; index < path.size(); index++) {
            Node pathIt = path.get(index);
            Bucket[] buckets = pathIt.getBuckets();
            result = result.concat("[");
            for(int j = 0; j < 2; j++) {
                result = result.concat(buckets.toString());
            }
            if(index < path.size() - 1) {
                result = result.concat("->");
            }
            result = result.concat("]");
        }
        return result;
    }
}
