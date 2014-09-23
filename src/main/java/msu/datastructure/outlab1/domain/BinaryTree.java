package msu.datastructure.outlab1.domain;

public class BinaryTree extends Graph {

	private BinaryTreeVertex root;

	public BinaryTreeVertex getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeVertex root) {
		this.root = root;
	}

	public void insert(BinaryTreeVertex newVertex) {
		BinaryTreeVertex aux = null;
		BinaryTreeVertex currentVertex = root;
		
		while(currentVertex != null) {
			aux = currentVertex;
			if(newVertex.getValue() < currentVertex.getValue()) {
				currentVertex = currentVertex.getLeft();
			} else {
				currentVertex = currentVertex.getRight();
			}
		}
		
		newVertex.setParent(aux);
		
		if(aux == null) {
			root = newVertex;
		} else {
			if(newVertex.getValue() < aux.getValue()) {
				aux.setLeft(newVertex);
				addEdge(new Edge(aux, newVertex, "left"));
			} else {
				aux.setRight(newVertex);
				addEdge(new Edge(aux, newVertex, "right"));
			}
		}
		
		addVertex(newVertex);
	}

	public BinaryTreeVertex interativeSearch(Integer value) {
		BinaryTreeVertex currentVertex = root;

		while (currentVertex != null && currentVertex.getValue() != value) {
			if (value < currentVertex.getValue()) {
				currentVertex = currentVertex.getLeft();
			} else {
				currentVertex = currentVertex.getRight();
			}
		}

		return currentVertex;
	}

	public BinaryTreeVertex recursiveSearch(Integer value) {
		return recursiveSearch(root, value);
	}
	
	public void delete(Integer value) {
		BinaryTreeVertex vertex = recursiveSearch(value);
		if(vertex != null)
			delete(vertex);
	}
	
	public void delete(BinaryTreeVertex vertex) {
		if(vertex.getLeft() == null) {
			transplant(vertex, vertex.getRight());
		} else if(vertex.getRight() == null) {
			transplant(vertex, vertex.getLeft());
		} else {
			BinaryTreeVertex minimumVertex = minimumTreeVertex(vertex.getRight());  			
			
			if(minimumVertex.getParent() != vertex) {
				transplant(minimumVertex, minimumVertex.getRight());
				minimumVertex.setRight(vertex.getRight());
				minimumVertex.getRight().setParent(minimumVertex);
			}
			
			transplant(vertex, minimumVertex);
			minimumVertex.setLeft(vertex.getLeft());
			minimumVertex.getLeft().setParent(minimumVertex);
		}
		
		removeVertex(vertex);
	}
	
	public void updateEdges() {
		this.clearAllEdges();
		this.updateEdgesInOrder(root);
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(BinaryTreeVertex vertex) {
		if(vertex == null)
			return;
		
		printInOrder(vertex.getLeft());
		System.out.println(vertex.getValue());
		printInOrder(vertex.getRight());
	}
	
	private BinaryTreeVertex recursiveSearch(BinaryTreeVertex vertex, Integer value) {
		if(vertex == null || vertex.getValue() == value) {
			return vertex;
		}
		
		if(value < vertex.getValue()) {
			return recursiveSearch(vertex.getLeft(), value);
		} else {
			return recursiveSearch(vertex.getRight(), value);
		}
	}
	
	private BinaryTreeVertex minimumTreeVertex(BinaryTreeVertex vertex) {
		while(vertex.getLeft() != null) {
			vertex = vertex.getLeft();
		}
		return vertex;
	}

	private void transplant(BinaryTreeVertex oldVertex, BinaryTreeVertex newVertex) {
		if(oldVertex.getParent() == null) {
			root = newVertex;
		} else if(oldVertex.isOnLeftSideOfHisParent()) {
			oldVertex.getParent().setLeft(newVertex);
		} else {
			oldVertex.getParent().setRight(newVertex);
		} 
		
		if(newVertex != null) {
			newVertex.setParent(oldVertex.getParent());
		}
	}
	
	private void updateEdgesInOrder(BinaryTreeVertex vertex) {
		if(vertex == null)
			return;
		updateEdgesInOrder(vertex.getLeft());
		addEdgeTo(vertex);
		updateEdgesInOrder(vertex.getRight());
	}

	private void addEdgeTo(BinaryTreeVertex vertex) {
		if(vertex != root) {
			if(vertex.isOnLeftSideOfHisParent()){
				addEdge(new Edge(vertex.getParent(), vertex, "left"));
			} else {
				addEdge(new Edge(vertex.getParent(), vertex, "right"));
			}
		}
	}
	
}
