package by.academy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegCommand implements ICommands {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/view/errors/400.jsp";
	}

}
