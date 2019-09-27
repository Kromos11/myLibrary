package Main;

import Controller.Command;
import Library.core.ICommandLine;
import Library.core.ILibrary;
import Library.core.ILibraryItem;
import Library.core.IReader;
import Library.core.IView;
import domain.Book;
import domain.Library;
import domain.Magazine;
import domain.Newspaper;
import domain.Reader;
import domain.LibraryItem;
import UI.View;
import static Controller.Command.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Application implements Serializable {
	private ILibrary library;
	private ICommandLine commandLine;
	private IView view;
	
	{
		this.library = new Library();
		this.commandLine = new View();
		this.view = (IView)this.commandLine;
	}
	
	
	@SuppressWarnings("incomplete-switch")
	public void run() {
		boolean run = true;
		while(run) {
			Command com1 = this.commandLine.getNextCommand(ADD_READERS,SHOW_READERS,ADD_LIBRARY_ITEM,SHOW_ALL_LIBRARY_ITEM,ISSUANCE_RECEPTION_BOOK,EXIT);
			switch(com1) {
			case ADD_READERS:addReader();
			break;
			case SHOW_READERS:showReaders();
			break;
			case ADD_LIBRARY_ITEM:addLibraryItem();
			break;
			case SHOW_ALL_LIBRARY_ITEM:this.showLibraryItem();
			break;
			case ISSUANCE_RECEPTION_BOOK: this.putBookReader();
			break;
			case EXIT:close();
			run = false;
			break;
			}
		}
	}

	private void showReaders() {
		this.view.showReaders(this.library.getReaders());
		
	}

	private void addReader() {
		String name = this.commandLine.getString("Введите имя Читателя");
		Command command1 = this.commandLine.getNextCommand("Добавить читателя с именем '"+name+"' ?",CONFIRM,DECLINE);
		switch(command1) {
		case CONFIRM: this.library.add(new Reader(name));
		this.view.showMessage("Новый читатель успешно добавлен");
		break;
		default:this.view.showMessage("...отмена.");
		}
	}
	
	private void addLibraryItem() {//Добавить литературу
		Command command2 = this.commandLine.getNextCommand("Добавить литературу: ",ADD_BOOK,ADD_MAGAZINE,ADD_NEWSPAPER);
		switch(command2) {
		case ADD_BOOK:this.addBook();
		break;
		case ADD_MAGAZINE:this.addMagazine();
		break;	
		case ADD_NEWSPAPER:this.addNewspaper();
		break;
		}
	}
	
	private void addBook() {
		String name = this.commandLine.getString("Введите название книги");
		Command command = this.commandLine.getNextCommand("Добавить книгу '"+name+"'?",CONFIRM,DECLINE);
		switch(command) {
		case CONFIRM:this.library.add(new Book(name));
		this.view.showMessage("Новая книга успешно добавлена");
		break;
		default:this.view.showMessage("...отмена.");
		}
		
	}
	
	private void addMagazine() {
		String name = this.commandLine.getString("Введите название журнала");
		Command command = this.commandLine.getNextCommand("Добавить журнал '"+name+"'?",CONFIRM,DECLINE);
		switch(command) {
		case CONFIRM:this.library.add(new Magazine(name));
		this.view.showMessage("Новый журнал успешно добавлен");
		break;
		default:this.view.showMessage("...отмена.");
		}
	}
	
	private void addNewspaper() {
		String name = this.commandLine.getString("Введите название газеты");
		Command command = this.commandLine.getNextCommand("Добавить газету '"+name+"'?",CONFIRM,DECLINE);
		switch(command) {
		case CONFIRM:this.library.add(new Newspaper(name));
		this.view.showMessage("Новая газета успешно добавлена");
		break;
		default:this.view.showMessage("...отмена.");
		}
	}
	
	
	private void issuanceReception() {//Добавить литературу
		Command command3 = this.commandLine.getNextCommand(ISSUANCE_BOOK,RECEPTION_BOOK);
		switch(command3) {
		case ISSUANCE_BOOK: this.putBookReader();
		break;
		case RECEPTION_BOOK:
		break;
		}
	}
	
	
	private void putBookReader() {
		IReader reader = reader(null);
		ILibraryItem item = item(null);
		String nameReader = this.commandLine.getString("Введите имя читателя");
		String nameBook = this.commandLine.getString("Введите название книги");
		Command command = this.commandLine.getNextCommand("Выдать книгу '"+nameBook+"' читателю '"+nameReader+"'?",CONFIRM,DECLINE);
		switch(command) {
		case CONFIRM:
			this.reader(nameReader);
			this.item(nameBook);
			item.busy(reader);
			try {
			
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
			this.view.showMessage("Данная книга выдана читателю "+nameReader);
		break;
		default:this.view.showMessage("...отмена.");
		}
	}
	
	
	
	private IReader reader(String nameReader) {
		List<IReader> readers = new ArrayList<>();
		if(readers.size()==0)return null;
		return readers.get(readers.size());
	}
	
	
	private ILibraryItem item(String nameBook) {
		List<ILibraryItem> item = new ArrayList<>();
		if(item.size()==0)return null;
		return item.get(item.size());
	}
	
	
	private void showLibraryItem() {
		this.view.showLibraryItems(this.library.getLibraryItemsList(null));
	}
	
	
	
	
	private void close() {
		this.view.showMessage("До свидания");	
	}

		
	
}
