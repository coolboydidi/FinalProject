import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Node;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Main{

    public static void main(String[] args){

        System.out.println("Hello world from Gephi script!");

        // Access the Gephi graph model
        GraphModel graphModel = new GraphModel();

        // Create nodes and a set for visited nodes
        Set<Node> visited = new HashSet<>();

        // Replace this with your actual graph data
        Node startNode = graphModel.factory().newNode("Start");
        Node nodeA = graphModel.factory().newNode("A");
        Node nodeB = graphModel.factory().newNode("B");
        Node nodeC = graphModel.factory().newNode("C");
        Node nodeD = graphModel.factory().newNode("D");

        graphModel.addEdgeType(startNode);
        graphModel.addEdgeType(nodeA);
        graphModel.addEdgeType(nodeB);
        graphModel.addEdgeType(nodeC);
        graphModel.addEdgeType(nodeD);

        // Simulate BFS and highlight visited nodes
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);
        startNode.setColor(Color.GREEN); // Mark start node as visited

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // Explore unvisited neighbors and highlight them
            for (Node neighbor : graphModel.getNeighbors(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    neighbor.setColor(Color.GREEN); // Mark neighbor as visited
                }
            }

            getViewer().refresh();
        }

        System.out.println("BFS completed!");
    }

}
