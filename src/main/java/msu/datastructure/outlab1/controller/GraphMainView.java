package msu.datastructure.outlab1.controller;

import javax.swing.JFrame;

import msu.datastructure.outlab1.domain.Edge;
import msu.datastructure.outlab1.domain.Graph;
import msu.datastructure.outlab1.domain.Vertex;
import msu.datastructure.outlab1.view.Visualizer;

public class GraphMainView {

	public static void main(String[] args) {
		
		Vertex vertexOne = new Vertex(100);
		Vertex vertexTwo = new Vertex(150);
		Vertex vertexThree = new Vertex(50);
		Vertex vertexFour = new Vertex(25);
		Vertex vertexFive = new Vertex(75);
		
		Edge edgeOne = new Edge(vertexOne, vertexTwo);
		Edge edgeTwo = new Edge(vertexOne, vertexThree);
		Edge edgeThree = new Edge(vertexThree, vertexFour);
		Edge edgeFour = new Edge(vertexThree, vertexFive);
		
		Graph graph = new Graph();
		graph.addVertex(vertexOne);
		graph.addVertex(vertexTwo);
		graph.addVertex(vertexThree);
		graph.addVertex(vertexFour);
		graph.addVertex(vertexFive);
		
		graph.addEdge(edgeOne);
		graph.addEdge(edgeTwo);
		graph.addEdge(edgeThree);
		graph.addEdge(edgeFour);
		
		Visualizer visualizer = new Visualizer(graph);
		JFrame frame = visualizer.buildVisualizer(visualizer.withTreeLayout());
		
		frame.setTitle("Out Lab 1 - André Coelho de Castro");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
}
