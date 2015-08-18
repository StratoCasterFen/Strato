package by.academy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEventsCommand implements ICommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "view/page.jsp";
	}

}
