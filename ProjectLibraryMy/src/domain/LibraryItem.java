package domain;

import java.io.Serializable;

import Library.core.ILibraryItem;
import Library.core.IReader;

public abstract class LibraryItem implements ILibraryItem{

	private static long ID_COUNTER;
	private long id;
	private String name;
	private IReader holder;// читатель у которого есть книга
	
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

	@Override
	public void busy(IReader reader) {
		this.holder = reader;
		reader.hold(this);
		
	}

	@Override
	public void free() {
		if(this.holder==null)return;
		this.holder.read(this);
		this.holder=null;
		
	}

	@Override
	public boolean isFree() {
		return this.holder==null;
	}
	
	
	
}
