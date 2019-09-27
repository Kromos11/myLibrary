package Library.core;

import Controller.Command;

public interface ICommandLine {
	Command getNextCommand(Command...commands);
	Command getNextCommand(String message,Command...comands);
	String getString(String question);
	int getInteger(String question);
	
}
