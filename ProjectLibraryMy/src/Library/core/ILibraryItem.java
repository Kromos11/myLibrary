package Library.core;

import Controller.Type;

public interface ILibraryItem extends ILibraryObject{

	Type getType();
	void busy(IReader reader);//������
	void free();//��������
	boolean isFree();// ������ ��� ���
	
}
