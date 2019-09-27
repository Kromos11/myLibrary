package UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Controller.Command;
import Library.core.ICommandLine;
import Library.core.ILibraryItem;
import Library.core.IReader;
import Library.core.IView;

public class View implements IView, ICommandLine {

	private Scanner scanner  = new Scanner(System.in);
	
	@Override
	public void showReaders(List<IReader> list) {
		for(IReader reader:list) {
			System.out.println("Читатель: "+reader.getName()+" (id:"+reader.getId()+")" );
		}
		
	}

	@Override
	public Command getNextCommand(Command...commands) {
		System.out.println("Варианты дальнейших действий:");
		boolean exit = false;
		boolean cont = false;
		int i = 1;
		Map<Integer,Command>commandMap = new HashMap<>();
		for(Command command:commands){
			if(command==Command.CONTINUE){
				cont = true;
				continue;
			}
			if(command==Command.EXIT){
				exit=true;
				continue;
			}
			commandMap.put(i, command);
			System.out.println((i++)+" - "+command.toString());
		}
		if(exit){
			commandMap.put(0, Command.EXIT);
			System.out.println("... для выхода из программы введите '0'");
		}
		if(cont){
			System.out.println("... любой другой ключ для выхода в главное меню");
		}
		Integer integer = this.getInteger("что делаем дальше?");
		Command command = commandMap.get(integer);
		return command!=null?command:Command.CONTINUE;
	}

	@Override
	public String getString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}

	@Override
	public int getInteger(String question) {
			System.out.println(question);
			String line = scanner.nextLine();
			try {
				int result = Integer.parseInt(line);
				return result;
			}catch(NumberFormatException e) {
				System.out.println("Некорруктный ввод!");
				return getInteger(question);
			}
	}
	
	public Command getNextCommand(String message,Command...comamnds) {
		System.out.println(message);
		return this.getNextCommand(comamnds);
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void showLibraryItems(List<ILibraryItem> list) {
			System.out.println("Cписок литературы:");
			for(ILibraryItem item:list) {
				System.out.println("id: "+item.getId()+", Тип: "+item.getType()+", Наименование: "+item.getName()+
					" Статус: "+(item.isFree()?"Свободна":"Занята"));
			}
			System.out.println("Всего: "+list.size()+" пунктов");
	}

	

}
