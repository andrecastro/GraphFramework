package msu.datastructure.outlab1.domain;

public class HeapVertex extends BinaryTreeVertex {

	private Integer index;

	public HeapVertex(Integer value) {
		super(value);
	}

	public HeapVertex(Integer value, Integer index) {
		super(value);
		this.index = index;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "v:" + getValue() + " | i:" + getIndex();
	}

}
