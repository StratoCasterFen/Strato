package by.academy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.command.CommandFactory;
import by.academy.command.ICommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Controller extends HttpServlet {
	
	public static Logger logger = LogManager.getLogger(Controller.class.getName());
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.debug("do post");
		action(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("do get");
		action(request, response);
	}

    private void action(HttpServletRequest request, HttpServletResponse response) {
    	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.error("Error "+e);
			e.printStackTrace();
		}
    	
		logger.info("controller start");
		String paramCommand = request.getParameter("command");
		if (paramCommand == null) {
			logger.debug("command is null");
			throw new IllegalArgumentException("command is null");
		}

		ICommand command = CommandFactory.getCommand(paramCommand);
		String nextPage = command.execute(request, response);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		try {
			logger.debug("command - "+paramCommand);
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			logger.error("Error "+e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("Error "+e);
			e.printStackTrace();
		}
	}
}
