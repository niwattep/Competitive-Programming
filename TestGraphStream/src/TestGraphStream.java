import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;
public class TestGraphStream {

	public static void main(String[] args) {
		Graph g = new SingleGraph("Test");
		g.addNode("A" );
		g.addNode("B" );
		g.addNode("C" );
		g.addEdge("AB", "A", "B");
		g.addEdge("BC", "B", "C");
		g.addEdge("CA", "C", "A");
		for (Node node : g) {
			node.setAttribute("ui.label", "ASF");
		}
		g.display();
		
	}

}
