package msu.datastructure.outlab1.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;

	public Graph() {
		this.vertices = new ArrayList<Vertex>();
		this.edges = new ArrayList<Edge>();
	}

	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void removeVertex(Vertex vertex) {
		this.vertices.remove(vertex);
	}

	public void removeEdge(Edge edge) {
		this.edges.remove(edge);
	}

	public void clearAllEdges() {
		this.edges.clear();
	}

	public HashMap<Vertex, String> verticesWithValues() {
		HashMap<Vertex, String> verticesWithValues = new HashMap<Vertex, String>();

		for (Vertex vertex : vertices) {
			verticesWithValues.put(vertex, vertex.getValue().toString());
		}

		return verticesWithValues;
	}

}
