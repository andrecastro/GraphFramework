package msu.datastructure.outlab1.domain;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {

	private Heap heap;
	private Integer[] array = { 16, 4, 9, 14, 7, 10, 3, 2, 8, 1 };

	@Before
	public void setUp() {
		heap = new Heap(asList(array));
	}

	@Test // after max-heapify should be 16, 14, 10, 8, 7, 9, 3, 2, 4, 1
	public void should_max_heapify_an_array() {
		assertEquals(new Integer(16), heap.getArray().get(0));
		assertEquals(new Integer(14), heap.getArray().get(1));
		assertEquals(new Integer(10), heap.getArray().get(2));
		assertEquals(new Integer(8), heap.getArray().get(3));
		assertEquals(new Integer(7), heap.getArray().get(4));
		assertEquals(new Integer(9), heap.getArray().get(5));
		assertEquals(new Integer(3), heap.getArray().get(6));
		assertEquals(new Integer(2), heap.getArray().get(7));
		assertEquals(new Integer(4), heap.getArray().get(8));
		assertEquals(new Integer(1), heap.getArray().get(9));
	}
	
	@Test
	public void should_build_a_heap_tree_from_an_array_and_heapify() {
		Integer[] array = { 8, 3, 9, 2, 6, 1, 12, 99, 5, 4};
		Heap heap = new Heap(asList(array));
		
		assertEquals(new Integer(99), heap.getRoot().getValue());
		assertEquals(new Integer(8), heap.getRoot().getLeft().getValue());
		assertEquals(new Integer(12), heap.getRoot().getRight().getValue());
		assertEquals(new Integer(5), heap.getRoot().getLeft().getLeft().getValue());
		assertEquals(new Integer(6), heap.getRoot().getLeft().getRight().getValue());
		assertEquals(new Integer(1), heap.getRoot().getRight().getLeft().getValue());
		assertEquals(new Integer(9), heap.getRoot().getRight().getRight().getValue());
	}
	
	@Test
	public void should_print_sorted_array() {
		heap.heapSort();
	}

}
