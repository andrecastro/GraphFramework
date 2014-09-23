package msu.datastructure.outlab1.domain;

public class BinaryTreeVertex extends Vertex {

	private BinaryTreeVertex left;
	private BinaryTreeVertex right;
	private BinaryTreeVertex parent;

	public BinaryTreeVertex(Integer value) {
		super(value);
	}

	public BinaryTreeVertex getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeVertex left) {
		this.left = left;
	}

	public BinaryTreeVertex getRight() {
		return right;
	}

	public void setRight(BinaryTreeVertex right) {
		this.right = right;
	}

	public BinaryTreeVertex getParent() {
		return parent;
	}

	public void setParent(BinaryTreeVertex parent) {
		this.parent = parent;
	}

	public boolean isOnLeftSideOfHisParent() {
		if(parent == null)
			return false;
		
		return this == this.parent.left;
	}
	
	public boolean isOnRightSideOfHisParent() {
		if(parent == null)
			return false;
		
		return this == this.parent.right;
	}

}
