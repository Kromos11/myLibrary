package Library.core;

import java.util.List;

public interface IReader extends ILibraryObject {

	void read(ILibraryItem item);// метод добавления прочтенных книг
	void hold(ILibraryItem item);//метод добавления книг которыe у читателя
	List<ILibraryItem> readItems();// список что прочитал
	boolean isRead(ILibraryItem item);
	
	
}
