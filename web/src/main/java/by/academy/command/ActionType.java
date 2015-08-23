package by.academy.command;

public enum ActionType {
	SIGNIN(){
		public ICommand getCommand() {return new SignInCommand();}
	},  
	REGISTRATION(){
		public ICommand getCommand() {return new RegCommand();} 
	},
	ADD_USER(){
		public ICommand getCommand() {return new AddUserCommand();} 
	},
	ADD_EVENT(){
		public ICommand getCommand() {return new AddEventCommand();} 
	},
	ADD_CRIMINAL(){
		public ICommand getCommand() {return new AddCriminalCommand();} 
	},
	VIEW_CRIMINALS(){
		public ICommand getCommand() {return new ViewCriminalsCommand();} 
	},
	VIEW_EVENTS(){
		public ICommand getCommand() {return new ViewEventsCommand();}
	};
	

	public abstract ICommand getCommand(); 
	 
	 
	 //public ICommand getCommand() {return command;}
	 
}
