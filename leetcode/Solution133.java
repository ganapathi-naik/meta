/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution133 {
    Map<Integer, Node> valToNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> neighbours = node.neighbors;
        valToNodeMap.putIfAbsent(node.val, new Node(node.val));
        Node newNode = valToNodeMap.get(node.val);
        if (neighbours.size() == 0) {
            return newNode;
        }
        Set<Node> visited = new HashSet<>();
        dfs(node, visited, newNode);
        return newNode;
    }

    void dfs(Node node, Set<Node> visited, Node newNode) {
        visited.add(node);
        for (Node neighbor : node.neighbors) {
            valToNodeMap.putIfAbsent(neighbor.val, new Node(neighbor.val));
            Node newNeighborNode = valToNodeMap.get(neighbor.val);
            newNode.neighbors.add(newNeighborNode);
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, newNeighborNode);
            }
        }
    }
}


class Solution133 {
    Map<Integer, Node> valToNewNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        return clone(node);
    }

    private Node clone(Node node) {
        if(valToNewNodeMap.containsKey(node.val)) {
            return valToNewNodeMap.get(node.val);
        }
        Node newNode = new Node(node.val);
        valToNewNodeMap.put(node.val, newNode);
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor));
        }
        return newNode;
    }
}
