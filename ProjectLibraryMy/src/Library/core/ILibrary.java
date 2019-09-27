package Library.core;

import java.util.List;

public interface ILibrary {
	
	List<IReader> getReaders();
	List<ILibraryItem> getLibraryItemsList(Object ob);
	List<ILibraryItem>getFreeItems();
	void add(ILibraryObject ob);
	
	
	
	
}
