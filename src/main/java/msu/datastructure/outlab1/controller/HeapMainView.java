package msu.datastructure.outlab1.controller;

import static java.util.Arrays.asList;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import msu.datastructure.outlab1.domain.Heap;
import msu.datastructure.outlab1.view.Visualizer;

public class HeapMainView {

	
	public static void main(String[] args) {
		Integer[] array = { 16, 4, 9, 14, 7, 10, 3, 2, 8, 1 };
		Heap heap = new Heap(asList(array));
		
		Visualizer visualizer = new Visualizer(heap);
		JFrame frame = visualizer.buildVisualizer(visualizer.withTreeLayout());
		
		JLabel label = new JLabel();
		label.setSize(400, 300);
		label.setText("Array >> " + heap.getArray());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		
		frame.add(label, BorderLayout.NORTH);
		frame.setTitle("Out Lab 1 - André Coelho de Castro");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		heap.heapSort();
	}
	
	
	
}
