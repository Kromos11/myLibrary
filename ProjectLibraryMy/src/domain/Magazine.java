package domain;

import Controller.Type;

public class Magazine extends LibraryItem{

	public Magazine(String name) {
		super(name);
	}

	@Override
	public Type getType() {
		return Type.MAGAZYNE;
	}

}
