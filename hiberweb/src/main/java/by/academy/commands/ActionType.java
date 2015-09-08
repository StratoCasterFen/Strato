package by.academy.commands;

public enum ActionType {
	SIGNIN(){
		public ICommands getCommand() {return new SignInCommand();}
	},  
	REGISTRATION(){
		public ICommands getCommand() {return new RegCommand();} 
	},
	ADD_USER(){
		public ICommands getCommand() {return new AddUserCommand();} 
	},
	ADD_EVENT_PAGE(){
		public ICommands getCommand() {return new AddEventPageCommand();} 
	},
	ADD_EVENT(){
		public ICommands getCommand() {return new AddEventCommand();} 
	},
	ADD_CRIMINAL_PAGE(){
		public ICommands getCommand() {return new AddCriminalPageCommand();} 
	},
	ADD_CRIMINAL(){
		public ICommands getCommand() {return new AddCriminalCommand();} 
	},
	VIEW_CRIMINALS(){
		public ICommands getCommand() {return new ViewCriminalsCommand();} 
	},
	VIEW_EVENTS(){
		public ICommands getCommand() {return new ViewEventsCommand();}
	};
	

	public abstract ICommands getCommand(); 
	 
	 
	 //public ICommands getCommand() {return command;}
	 
}
