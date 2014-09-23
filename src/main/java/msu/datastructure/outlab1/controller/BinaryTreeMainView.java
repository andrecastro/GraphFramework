package msu.datastructure.outlab1.controller;

import javax.swing.JFrame;

import msu.datastructure.outlab1.domain.BinaryTree;
import msu.datastructure.outlab1.domain.BinaryTreeVertex;
import msu.datastructure.outlab1.view.Visualizer;

public class BinaryTreeMainView {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		
		BinaryTreeVertex vertex1 = new BinaryTreeVertex(1);
		BinaryTreeVertex vertex2 = new BinaryTreeVertex(2);
		BinaryTreeVertex vertex3 = new BinaryTreeVertex(3);
		BinaryTreeVertex vertex4 = new BinaryTreeVertex(4);
		BinaryTreeVertex vertex5 = new BinaryTreeVertex(5);
		BinaryTreeVertex vertex6 = new BinaryTreeVertex(6);
		BinaryTreeVertex vertex7 = new BinaryTreeVertex(7);
		BinaryTreeVertex vertex8 = new BinaryTreeVertex(8);
		BinaryTreeVertex vertex9 = new BinaryTreeVertex(9);
		BinaryTreeVertex vertex10 = new BinaryTreeVertex(10);
		
		binaryTree.insert(vertex6);
		binaryTree.insert(vertex4);
		binaryTree.insert(vertex9);
		binaryTree.insert(vertex8);
		binaryTree.insert(vertex7);
		binaryTree.insert(vertex10);
		binaryTree.insert(vertex5);
		binaryTree.insert(vertex3);
		binaryTree.insert(vertex2);
		binaryTree.insert(vertex1);
		
		binaryTree.delete(vertex4);
		binaryTree.delete(vertex3);
		binaryTree.updateEdges();
		binaryTree.printInOrder();
		
		Visualizer visualizer = new Visualizer(binaryTree);
		JFrame frame = visualizer.buildVisualizer(visualizer.withTreeLayout());

		frame.setTitle("Out Lab 1 - André Coelho de Castro");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
