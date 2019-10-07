package Library.core;

import java.util.List;

public interface IReader extends ILibraryObject {

	void read(ILibraryItem item);// ����� ���������� ���������� ����
	void hold(ILibraryItem item);//����� ���������� ���� ������e � ��������
	List<ILibraryItem> readItems();// ������ ��� ��������
	boolean isRead(ILibraryItem item);
	
	
}
