package by.academy.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.dao.CustomUserDao;
import by.academy.dto.UserDto;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignInCommand implements ICommands {

	public static Logger logger = LogManager.getLogger(SignInCommand.class.getName());
	private CustomUserDao userDao;
	private UserService userService = null;
	private UserDto authUser;
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		logger.info("execute start");
		String page = null;
		String userName = request.getParameter("j_username");
		String password = request.getParameter("j_password");

		logger.info(userName);
		request.setAttribute("username", userName);
		page = "/WEB-INF/view/first.jsp";

		try {
			userService = new UserServiceImpl();
			authUser = userService.authorization(userName, password);
			logger.info(authUser);
		} catch (ServiceException e) {
			logger.error("WEB:" + e);
			request.setAttribute("errorAuth", "Error: " + e);
		}

		if (authUser != null) {
			request.setAttribute("user", userName);
			logger.debug("WEB:login correct");
			HttpSession session = request.getSession();
			session.setAttribute("userId", authUser.getId());
		} else {
			request.setAttribute("errorAuth", "invalid login or password!");
			page = ("/WEB-INF/view/login.jsp");
			logger.error("WEB:login incorrect");
		}
		return page;
	}

}
