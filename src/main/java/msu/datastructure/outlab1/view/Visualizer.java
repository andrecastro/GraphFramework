package msu.datastructure.outlab1.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import msu.datastructure.outlab1.domain.Edge;
import msu.datastructure.outlab1.domain.Graph;
import msu.datastructure.outlab1.domain.Vertex;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class Visualizer {

	private Graph graph;

	public Visualizer(Graph graph) {
		this.graph = graph;
	}
	
	public JFrame buildVisualizer(Layout<Vertex, Edge> layout) {
		BasicVisualizationServer<Vertex, Edge> visualizationServer = new BasicVisualizationServer<Vertex, Edge>(layout);
		visualizationServer.getRenderContext().setVertexLabelTransformer(buildVerticesValues());
		visualizationServer.getRenderContext().setEdgeLabelTransformer(buildEdgesValues());
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.add(visualizationServer, BorderLayout.CENTER);

		return frame;
	}

	/* Methods that create the layouts to put on the BasicVisualizationServer */
	
	public TreeLayout<Vertex, Edge> withTreeLayout() {
		return new TreeLayout<Vertex, Edge>(convertGraphToDelegateForest());
	}
	
	public CircleLayout<Vertex, Edge> withCircleLayout() {
		return new CircleLayout<Vertex, Edge>(convertGraphToDirectedGraph());
	}
	
	public ISOMLayout<Vertex, Edge> withISOMLayout() {
		return new ISOMLayout<Vertex, Edge>(convertGraphToDirectedGraph());
	}
	
	
	/* Methods to convert our graph to DelegateForest */
	
	private DelegateForest<Vertex, Edge> convertGraphToDelegateForest() {
		DelegateForest<Vertex, Edge> forest = new DelegateForest<Vertex, Edge>();
		addVerticesToDelegateForest(forest);
		addEdgesToDelegateForest(forest);
		return forest;
	}

	private void addVerticesToDelegateForest(Forest<Vertex, Edge> forest) {
		for (Vertex vertex : graph.getVertices()) {
			forest.addVertex(vertex);
		}
	}

	private void addEdgesToDelegateForest(Forest<Vertex, Edge> forest) {
		for (Edge edge : graph.getEdges()) {
			forest.addEdge(edge, edge.getVertexOne(), edge.getVertexTwo());
		}
	}
	
	
	/* Methods to convert our graph to Jung's DirectedGraph */
	
	private DirectedSparseGraph<Vertex, Edge> convertGraphToDirectedGraph() {
		DirectedSparseGraph<Vertex, Edge> directedGraph = new DirectedSparseGraph<Vertex, Edge>();
		addVerticesToDirectedGraph(directedGraph);
		addEdgesToDirectedGraph(directedGraph);
		return directedGraph;
	}
	
	private void addEdgesToDirectedGraph(DirectedGraph<Vertex, Edge> directedGraph) {
		for (Edge edge : graph.getEdges()) {
			directedGraph.addEdge(edge, edge.getVertexOne(), edge.getVertexTwo());
		}
	}
	
	private void addVerticesToDirectedGraph(DirectedGraph<Vertex, Edge> directedGraph) {
		for (Vertex vertex : graph.getVertices()) {
			directedGraph.addVertex(vertex);
		}
	}
	
	/* Method that create the values of the vertices to be shown */
	
	private Transformer<Vertex, String> buildVerticesValues() {
		return new Transformer<Vertex, String>() {
			@Override
			public String transform(Vertex vertex) {
				return vertex.toString();
			}
		};
	}
	
	private Transformer<Edge, String> buildEdgesValues() {
		return new ToStringLabeller<Edge>();
	}

}
