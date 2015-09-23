package by.academy.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.commands.CommandFactory;
import by.academy.commands.ICommands;


public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static Logger logger = LogManager.getLogger(Controller.class.getName());
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                          throws ServletException, IOException {
        logger.info("doPost");
        performAction(request, response);
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                    throws ServletException, IOException {
    	
    	logger.info("doGet");
    	performAction(request, response);
    }
    
    private void performAction(HttpServletRequest request, HttpServletResponse response) {
    	logger.info("performAction");
		String paramCommand = request.getParameter("command");
		if (paramCommand == null) {
			throw new IllegalArgumentException("command is null");
		}
		logger.info("command: "+paramCommand);
		ICommands command = CommandFactory.getCommand(paramCommand);
		String nextPage = command.execute(request, response);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
