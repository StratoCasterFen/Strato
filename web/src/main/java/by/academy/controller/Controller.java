package by.academy.controller;

import by.academy.command.CommandFactory;
import by.academy.command.ICommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
	public static Logger logger = LogManager.getLogger(Controller.class.getName());
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                          throws ServletException, IOException {
      //  super.doPost(request, response);
        logger.info("doPost");
        performAction(request, response);
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                    throws ServletException, IOException {
    	
    	logger.info("doGet");
//		response.setContentType("text/html");
//
//		String eventname = "Hello World!";
//		request.setAttribute("textA", eventname);
//		String varTextB = "It JSP.";
//		request.setAttribute("textB", varTextB);
//
//		request.setAttribute("loc", Locale.getDefault());
//		request.getSession().setAttribute("calend", Calendar.getInstance());
//		request.getRequestDispatcher("/WEB-INF/view/eventlist.jsp").forward(request, response);
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("login.jsp");
		// dispatcher.forward(request, response);
    }
    
    private void performAction(HttpServletRequest request, HttpServletResponse response) {
		String paramCommand = request.getParameter("command");
		if (paramCommand == null) {
			throw new IllegalArgumentException("command is null");
		}
		
		ICommand command = CommandFactory.getCommand(paramCommand);
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
