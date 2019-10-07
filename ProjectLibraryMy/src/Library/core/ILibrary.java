package Library.core;

import java.util.List;
import java.util.Set;

public interface ILibrary {
	
	List<IReader> getReaders();
	List<ILibraryItem> getLibraryItemsList(Object ob);
	List<ILibraryItem> getLibraryItemFree();
	List<ILibraryItem>getFreeItems();
	List<IReader>getHolder();
	List<ILibraryItem> onHold();//список книг на руках
	void add(ILibraryObject ob);
	
	
}
