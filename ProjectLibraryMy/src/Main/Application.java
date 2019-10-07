package Main;

import Controller.Command;
import Library.core.ICommandLine;
import Library.core.ILibrary;
import Library.core.ILibraryItem;
import Library.core.ILibraryObject;
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
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.StreamPrintService;


public class Application implements Serializable {
	private ILibrary library;
	private ICommandLine commandLine;
	private IView view;
	private IReader reader;
	
	{
		this.library = new Library();
		this.commandLine = new View();
		this.view = (IView)this.commandLine;
		this.reader = new Reader();
	}
	
	
	@SuppressWarnings("incomplete-switch")
	public void run() {
		boolean run = true;
		while(run) {
			Command com1 = this.commandLine.getNextCommand(ADD_READERS,SHOW_READERS,ADD_LIBRARY_ITEM,SHOW_ALL_LIBRARY_ITEM,ISSUANCE_RECEPTION_BOOK,SEARCH_READER,EXIT);
			switch(com1) {
			case ADD_READERS:addReader();
			break;
			case SHOW_READERS:showReaders();
			break;
			case ADD_LIBRARY_ITEM:addLibraryItem();
			break;
			case SHOW_ALL_LIBRARY_ITEM:this.showLibraryItem();
			break;
			case ISSUANCE_RECEPTION_BOOK: this.issuanceReception();;
			break;
			case SEARCH_READER: this.searchReader();
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
	
	
	private void issuanceReception() {//Выдать литературу 
		Command command3 = this.commandLine.getNextCommand(ISSUANCE_BOOK,RECEPTION_BOOK);
		switch(command3) {
		case ISSUANCE_BOOK: this.putBookReader();
		break;
		case RECEPTION_BOOK:
		break;
		default:this.view.showMessage("...отмена.");
		}
	}
	
	
	private void putBookReader() {
		String nameReader = this.commandLine.getString("Введите имя читателя");
		if(this.library.getReaders().stream().map(r-> r.getName()).collect(Collectors.toList()).contains(nameReader)) {
			String nameBook = this.commandLine.getString("Введите название книги");
			if(this.library.getFreeItems().stream().map(i-> i.getName()).collect(Collectors.toList()).contains(nameBook)) {
				List<IReader> reader = putReader(nameReader);
				List<ILibraryItem> item = putItem(nameBook);
				if(reader!=null&&item!=null) {
					System.out.println(putReader(nameReader));
				}else {
					System.out.println("Проверка не прошла");
				}
			}else {
				System.out.println("Такой книги нет в библиотеке.");
			}
		}else {
			System.out.println("Такого читателя нет в библиотеке.");
		}
	}
	
	
	private List<IReader> putReader(String nameReader) {
		return  this.library.getReaders().stream().filter(r-> r.getName()==nameReader).collect(Collectors.toList());
	}
	
	private List<ILibraryItem> putItem(String nameBook) {
		return this.library.getFreeItems().stream().filter(i-> i.getName()==nameBook).collect(Collectors.toList());
	}
		
		
	
	
	
	
	private void searchReader() {
		String name = this.commandLine.getString("Введите имя читателя");
		if(this.library.getReaders().stream().map(r-> r.getName()).collect(Collectors.toList()).contains(name)){
			this.library.getReaders().stream().map(r-> r.getName().toString()).collect(Collectors.filtering(r-> r==name, Collectors.toList())).forEach(System.out::println);
		}else {
			System.out.println("Такого читателя нет в библиотеке.");
		}
				
	}
		
	
	
	private void showLibraryItem() {
		this.view.showLibraryItems(this.library.getLibraryItemsList(null));
		
	}
		
	
	private void close() {
		this.view.showMessage("До свидания");	
	}
	
	
}
