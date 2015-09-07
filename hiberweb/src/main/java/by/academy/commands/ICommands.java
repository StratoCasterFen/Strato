package by.academy.commands;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public interface ICommands {
	String execute(HttpServletRequest request, HttpServletResponse response);
}



