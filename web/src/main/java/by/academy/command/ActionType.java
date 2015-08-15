package by.academy.command;

public enum ActionType {

	 SIGNIN 		(new SignInCommand()),  
	 REGISTRATION 	(new RegCommand()), 
	 VIEWEVENTS 	(new ViewEventsCommand());
	 
	 private ICommand command; 
	 private void ActionTypes (ICommand command) {this.command = command;}
	 
	 public ICommand getCommand() {return command;}
	 
}
