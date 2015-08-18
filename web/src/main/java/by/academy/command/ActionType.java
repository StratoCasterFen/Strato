package by.academy.command;

public enum ActionType {
	SIGNIN(){
		public ICommand getCommand() {return new SignInCommand();}
	},  
	REGISTRATION(){
		public ICommand getCommand() {return new RegCommand();} 
	},
	VIEWEVENTS(){
		public ICommand getCommand() {return new ViewEventsCommand();}
	};

	public abstract ICommand getCommand(); 
	 
	 
	 //public ICommand getCommand() {return command;}
	 
}
