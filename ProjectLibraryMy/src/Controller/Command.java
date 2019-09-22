package Controller;

public enum Command {

	EXIT("Выход"),
	SHOW_READERS("Показать читателей"), 
	CONTINUE("Продолжить"), 
	ADD_READERS("Добавить читателя"),
	CONFIRM("Подтвердить"),
	DECLINE("Отклонить"),
	ADD_LIBRARY_ITEM("Добавить литературу"),
	ADD_BOOK("Добавить книгу"),
	ADD_MAGAZINE("Добавить журнал"),
	ADD_NEWSPAPER("Добавить газету"),
	SAVE("Сохранить данные"),
	SHOW_ALL_LIBRARY_ITEM("Показать весь список библиотеки");
	
	
	
	
	private String command;
	
	private Command(String command) {
		this.command=command;
	}
	
	public String toString() {
		return this.command;
	}
}
