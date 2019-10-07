package Library.core;

import java.util.List;
import java.util.Set;

public interface ILibrary {
	
	List<IReader> getReaders();
	List<ILibraryItem> getLibraryItemsList(Object ob);
	List<ILibraryItem> getLibraryItemFree();
	List<ILibraryItem>getFreeItems();
	List<IReader>getHolder();
	List<ILibraryItem> onHold();//������ ���� �� �����
	void add(ILibraryObject ob);
	
	
}
