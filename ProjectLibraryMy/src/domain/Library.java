package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import Library.core.IArticle;
import Library.core.IArticleContained;
import Library.core.ILibrary;
import Library.core.ILibraryItem;
import Library.core.ILibraryObject;
import Library.core.IReader;
import domain.Reader;

public class Library implements ILibrary{

	private Map<Serializable,IReader>readers = new HashMap<>();
	private Map<Serializable,ILibraryItem>items= new HashMap<>();
	private Map<IArticle, IArticleContained>articles= new HashMap<>();
	
	@Override
	public List <IReader> getReaders() {
		return new ArrayList<>(this.readers.values());
	}
	
	@Override
	public List<ILibraryItem> getLibraryItemsList(Object ob) {
		return new ArrayList<>(this.items.values());
	}

	@Override
	public void add(ILibraryObject ob) {
		if(ob instanceof IReader) {
			this.readers.put(ob.getId(), (IReader) ob);
			return;
		}
		if(ob instanceof ILibraryItem) {
			this.items.put(ob.getId(), (ILibraryItem) ob);
		}
		if(ob instanceof IArticleContained) {
			List<IArticle>list = ((IArticleContained)ob).getArticles();
			for(IArticle article:list)this.articles.put(article, (IArticleContained)ob);
		}
	}
	


	@Override
	public List<ILibraryItem> getFreeItems() {
		return this.items.values().stream().filter(i -> i.isFree()).collect(Collectors.toList());
	}

	@Override
	public List<IReader> getHolder() {
		return new ArrayList<>(this.readers.values());
	}

	@Override
	public List<ILibraryItem> getLibraryItemFree() {
		return new ArrayList<>(this.items.values());
	}

	@Override
	public List<ILibraryItem> onHold() {
		return new ArrayList<>(this.items.values());
	}

	

	
}
