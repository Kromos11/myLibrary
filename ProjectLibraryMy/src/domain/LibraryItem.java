package domain;

import java.io.Serializable;

import Library.core.ILibraryItem;

public abstract class LibraryItem implements ILibraryItem{

	private static long ID_COUNTER;
	private long id;
	private String name;
	
	public LibraryItem(String name) {
		this.name=name;
		this.id=ID_COUNTER++;
	}

	@Override
	public Serializable getId() {
		return this.id;
	}

	@Override
	public Serializable getName() {
		return this.name;
	}
	
	
}
