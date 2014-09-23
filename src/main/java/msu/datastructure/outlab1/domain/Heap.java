package msu.datastructure.outlab1.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap
 * 
 * The algorithms buildMaxHeap, heapSort and maxHeapify are from
 * the book INTRODUCTION TO ALGORITHMS by Thomas H. Cormer, et al.
 * third edition, and they can be found on chapter 6, pages 151-162.
 * 
 * @author André Castro
 * @version 20 Sep 2014
 */
public class Heap extends BinaryTree {

	private List<Integer> array;
	private int size = 0;
	private final int FIRST_INDEX = 0;

	public Heap(List<Integer> array) {
		this.setArray(array);
	}
	
	public List<Integer> getArray() {
		return array;
	}

	// initialize attributes and build the max heap
	public void setArray(List<Integer> array) {
		this.array = array;
		this.size = array.size();
		this.buildHeapTree();
		this.buildMaxHeap();
	}
	
	// sort the array and print it sorted
	public void heapSort() {
		Heap heap = new Heap(new ArrayList<Integer>(array));
		int arrayLength = heap.getArray().size();
		
		for (int i = arrayLength; i > 0 ; i--) {
			heap.exchangeValues(FIRST_INDEX, i-1);
			heap.size = heap.size - 1;
			heap.buildMaxHeap();
		}
		
		System.out.println(heap.getArray());
	}
	
	// build max heap method 
	private void buildMaxHeap() {
		for (int i = array.size()/2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	// method to build the heap tree from the array
	private void buildHeapTree() {
		HeapVertex root = new HeapVertex(array.get(FIRST_INDEX), FIRST_INDEX);
		setRoot(root);
		getVertices().add(root);
		buildTreeInPreOrder(root, FIRST_INDEX);
	}
	
	// method to build the tree in pre order
	private void buildTreeInPreOrder(BinaryTreeVertex node, int index) {
		int leftChildIndex = leftChildIndex(index);
		int rightChildIndex = rightChildIndex(index);
		int arraySize = array.size();
		
		if(leftChildIndex < arraySize) {
			HeapVertex leftChild = new HeapVertex(array.get(leftChildIndex), leftChildIndex);
			node.setLeft(leftChild);
			getEdges().add(new Edge(node, leftChild, "left"));
			getVertices().add(leftChild);
		}
		
		if(rightChildIndex < arraySize) {
			HeapVertex rightChild = new HeapVertex(array.get(rightChildIndex), rightChildIndex);
			node.setRight(rightChild);
			getEdges().add(new Edge(node, rightChild, "right"));
			getVertices().add(rightChild);
		}
		
		if(leftChildIndex < arraySize) {
			buildTreeInPreOrder(node.getLeft(), leftChildIndex);
		}
		
		if(rightChildIndex < arraySize) {
			buildTreeInPreOrder(node.getRight(), rightChildIndex);
		}
	}
	
	
	private void maxHeapify(int index) {
		int leftChildIndex = leftChildIndex(index);
		int rightChildIndex = rightChildIndex(index);
		int largest = index;
		
		if(leftChildIndex < size && array.get(leftChildIndex) > array.get(index)) {
			largest = leftChildIndex;
		} 
			
		if(rightChildIndex < size && array.get(rightChildIndex) > array.get(largest)) {
			largest = rightChildIndex;
		}
		
		if(largest != index) {
			exchangeValues(index, largest);
			maxHeapify(largest);
		}
	}
	
	private void exchangeValues(int index, int largest) {
		exchangeValuesOnArray(index, largest);
		exchangeValuesOnTree(index, largest);
	}

	private void exchangeValuesOnArray(int index, int largest) {
		Integer aux = array.get(index);
		array.set(index, array.get(largest));
		array.set(largest, aux);
	}
	
	private void exchangeValuesOnTree(int index, int largest) {
		HeapVertex currentVertex = findVertexByIndex(index);
		HeapVertex largestVertex = findVertexByIndex(largest);
		
		Integer aux = currentVertex.getValue();
		currentVertex.setValue(largestVertex.getValue());
		largestVertex.setValue(aux);
	}

	private int leftChildIndex(int index) {
		return (2*index) + 1;
	}
	
	private int rightChildIndex(int index) {
		return (2*index) + 2;
	}
	
	// method to find the vertex by the index
	private HeapVertex findVertexByIndex(int index) {
		for (Vertex vertex : getVertices()) {
			if(((HeapVertex) vertex).getIndex() == index) {
				return (HeapVertex) vertex;
			}
		}
		return null;
	}

}
