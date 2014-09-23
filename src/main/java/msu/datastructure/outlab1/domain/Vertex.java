package msu.datastructure.outlab1.domain;

public class Vertex {

	private Integer value;

	public Vertex(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

}
