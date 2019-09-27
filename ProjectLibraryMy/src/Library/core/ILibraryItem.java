package Library.core;

import Controller.Type;

public interface ILibraryItem extends ILibraryObject{

	Type getType();
	void busy(IReader reader);//занята
	void free();//сводобна
	boolean isFree();// занята или нет
	
}
