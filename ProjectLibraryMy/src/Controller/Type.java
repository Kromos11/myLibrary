package Controller;

public enum Type {

	BOOK("�����"),
	MAGAZYNE("������"),
	NEWSPAPER("������");
	
	
	private String type;
	
	private Type (String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
	
}
