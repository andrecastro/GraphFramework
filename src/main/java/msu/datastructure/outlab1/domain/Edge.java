package msu.datastructure.outlab1.domain;

public class Edge {

	private Integer value;
	private Vertex vertexOne;
	private Vertex vertexTwo;
	private String label;

	public Edge(Vertex vertexOne, Vertex vertexTwo) {
		this.vertexOne = vertexOne;
		this.vertexTwo = vertexTwo;
	}
	
	public Edge(Vertex vertexOne, Vertex vertexTwo, String label) {
		this(vertexOne, vertexTwo);
		this.label = label;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Vertex getVertexOne() {
		return vertexOne;
	}

	public Vertex getVertexTwo() {
		return vertexTwo;
	}
	
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label;
	}
	
}
