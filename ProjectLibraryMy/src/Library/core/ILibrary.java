package Library.core;

import java.util.List;

public interface ILibrary {
	
	List<IReader> getReader();
	List<ILibraryItem> getLibraryItemsList(Object ob);
	void add(ILibraryObject ob);
	
	
	
	
}
