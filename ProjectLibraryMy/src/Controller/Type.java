package Controller;

public enum Type {

	BOOK("Книга"),
	MAGAZYNE("Журнал"),
	NEWSPAPER("Газета");
	
	
	private String type;
	
	private Type (String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.type;
	}
	
}
