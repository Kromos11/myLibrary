package Library.core;

import java.util.List;

public interface IReader extends ILibraryObject {

	void read(ILibraryItem item);// метод добавления прочтенных книг
	void hold(ILibraryItem item);//метод добавления книг которые у читателя
	List<ILibraryItem> readItems();// список что прочитал
	List<ILibraryItem> onHold();//список книг на руках
	boolean isRead(ILibraryItem item);
	
	
}
