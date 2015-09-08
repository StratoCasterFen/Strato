package by.academy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEventPageCommand implements ICommands {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/view/addevent.jsp";
	}

}
