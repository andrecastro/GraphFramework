package msu.datastructure.outlab1.domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	private BinaryTree binaryTree;

	@Before
	public void setUP() {
		binaryTree = new BinaryTree();
	}

	@Test
	public void should_insert_node_as_root() {
		BinaryTreeVertex newRoot = new BinaryTreeVertex(1);
		binaryTree.setRoot(newRoot);
		assertEquals(newRoot, binaryTree.getRoot());
	}

	@Test
	public void should_insert_first_node_as_root_using_the_insert_method() {
		BinaryTreeVertex newRoot = new BinaryTreeVertex(1);
		binaryTree.insert(newRoot);
		assertEquals(newRoot, binaryTree.getRoot());
	}

	@Test
	public void should_insert_vertex_on_the_left_side() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		assertEquals(leftNode, binaryTree.getRoot().getLeft());
	}

	@Test
	public void should_insert_vertex_on_the_right_side() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex rightNode = new BinaryTreeVertex(6);
		binaryTree.insert(root);
		binaryTree.insert(rightNode);
		assertEquals(rightNode, binaryTree.getRoot().getRight());
	}

	@Test
	public void should_insert_on_left_side_second_level() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(4);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(3);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		assertEquals(leftNodeSecondLevel, binaryTree.getRoot().getLeft().getLeft());
	}
	
	@Test
	public void should_insert_on_right_side_second_level() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		assertEquals(leftNodeSecondLevel, binaryTree.getRoot().getLeft().getRight());
	}

	@Test
	public void should_return_null_searching_on_a_null_tree_using_interative_search() {
		assertNull(binaryTree.interativeSearch(10));
	}
	
	@Test
	public void should_return_a_vertex_if_the_value_is_found_using_interative_search() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNotNull(binaryTree.interativeSearch(3));
		assertNotNull(binaryTree.interativeSearch(4));
		assertNotNull(binaryTree.interativeSearch(5));
	}
	
	@Test
	public void should_return_null_if_a_vertex_is_not_found_using_interative_search() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNull(binaryTree.interativeSearch(6));
	}
	
	@Test
	public void should_return_null_searching_on_a_null_tree_using_recursive_search() {
		assertNull(binaryTree.recursiveSearch(10));
	}
	
	@Test
	public void should_return_a_vertex_if_the_value_is_found_using_recursive_search() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNotNull(binaryTree.recursiveSearch(3));
		assertNotNull(binaryTree.recursiveSearch(4));
		assertNotNull(binaryTree.recursiveSearch(5));
	}
	
	@Test
	public void should_return_null_if_a_vertex_is_not_found_using_recursive_search() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNull(binaryTree.recursiveSearch(6));
	}

	@Test
	public void should_delete_a_value() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNotNull(binaryTree.recursiveSearch(3));
		binaryTree.delete(new BinaryTreeVertex(3));
		assertNull(binaryTree.recursiveSearch(3));
	}
	
	@Test
	public void should_delete_the_root_and_put_the_left_node_as_root() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(3);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(4);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNotNull(binaryTree.recursiveSearch(5));
		binaryTree.delete(root);
		assertNull(binaryTree.recursiveSearch(5));
		assertEquals(leftNode, binaryTree.getRoot());
	}
	
	@Test
	public void should_delete_the_root_and_put_the_right_node_as_root() {
		BinaryTreeVertex root = new BinaryTreeVertex(5);
		BinaryTreeVertex rightNode = new BinaryTreeVertex(7);
		BinaryTreeVertex leftNodeSecondLevel = new BinaryTreeVertex(6);
		binaryTree.insert(root);
		binaryTree.insert(rightNode);
		binaryTree.insert(leftNodeSecondLevel);
		
		assertNotNull(binaryTree.recursiveSearch(5));
		binaryTree.delete(root);
		assertNull(binaryTree.recursiveSearch(5));
		assertEquals(rightNode, binaryTree.getRoot());
	}
	
	@Test
	public void should_delete_a_balanced_node() {
		BinaryTreeVertex root = new BinaryTreeVertex(6);
		BinaryTreeVertex leftNode = new BinaryTreeVertex(5);
		BinaryTreeVertex rightNode = new BinaryTreeVertex(7);
		binaryTree.insert(root);
		binaryTree.insert(leftNode);
		binaryTree.insert(rightNode);
		
		assertNotNull(binaryTree.recursiveSearch(6));
		binaryTree.delete(root);
		assertNull(binaryTree.recursiveSearch(6));
		assertEquals(rightNode, binaryTree.getRoot());
	}
	
}

