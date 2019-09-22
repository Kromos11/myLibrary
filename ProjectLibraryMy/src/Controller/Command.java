package Controller;

public enum Command {

	EXIT("�����"),
	SHOW_READERS("�������� ���������"), 
	CONTINUE("����������"), 
	ADD_READERS("�������� ��������"),
	CONFIRM("�����������"),
	DECLINE("���������"),
	ADD_LIBRARY_ITEM("�������� ����������"),
	ADD_BOOK("�������� �����"),
	ADD_MAGAZINE("�������� ������"),
	ADD_NEWSPAPER("�������� ������"),
	SAVE("��������� ������"),
	SHOW_ALL_LIBRARY_ITEM("�������� ���� ������ ����������");
	
	
	
	
	private String command;
	
	private Command(String command) {
		this.command=command;
	}
	
	public String toString() {
		return this.command;
	}
}
