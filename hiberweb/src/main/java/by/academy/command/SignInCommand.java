package by.academy.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignInCommand  implements ICommand{

	public static Logger logger = LogManager.getLogger(SignInCommand.class.getName());

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("execute start");
		String page = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
	        
	        //request.setAttribute("textA", eventname);
//			String varTextB = "It JSP.";
		request.setAttribute("username", userName);
			
		//UserServiceImpl userService= new UserServiceImpl();
	       // UserService userService = new UserService();
	    //    try {
			//	if (userService.authorization(userName, password)!=null) {
//	            request.setAttribute("user", login);
				    page = "/WEB-INF/view/first.jsp";
				//} else {
//	            request.setAttribute("errorLoginPassMessage",
//	                    MessageManager.getProperty("message.loginError"));
					
				//	request.setAttribute("errorAuth", "Ivalid login or password!");
				//    page = ("/WEB-INF/view/login.jsp");
			//	}
//			} catch (ServiceException e) {
//				logger.error("error");
//				e.printStackTrace();
//			} catch (DaoException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        return page;
//	    }
//	        
		//		    User user = validate(request);
//	        if (user == null) {
//	            errorHandling(request);
//	            return nextPage;
//	        }
//	        User authorizedUser = null;
//	        try {
//	            authorizedUser = authorizeUser(user);
//	        } catch (ServiceException e) {
//	            errorHandling(request, "Cannot authorize user", e);
//	        }
//	        if (authorizedUser == null) {
//	            errorHandling(request);
//	            return nextPage;
//	        }
//	        addUserToSession(request, authorizedUser);
	       // nextPage = "/WEB-INF/view/test.jsp";
//	        return nextPage;
			return page;
	    }

//	    private User authorizeUser(User user) throws ServiceException {
//	        User authorizedUser;
//	        Log.debug("Get DAO");
//	        UserDAO userDAO = UserDAOImpl.getInstance();
//	        Log.debug("Get Service");
//	        UserService userService = UserServiceImpl.getInstance();
//	        Log.debug("Dependency injection");
//	        userService.setUserDAO(userDAO);
//	        Log.debug("Authorizing user");
//	        authorizedUser = userService.authorizeUser(user);
//	        Log.debug("Authentication successful");
//	        return authorizedUser;
//	    }

//	    private User validate(HttpServletRequest request) {
//	        User user = null;
//	        Log.debug("Checking valid input");
//	        String email = request.getParameter("email");
//	        String password = request.getParameter("password");
//	        if (Objects.equals(email, "") || Objects.equals(password, "")) {
//	            Log.debug("Input not valid. Empty form.");
//	        } else {
//	            user = new User(email, password);
//	        }
//	        return user;
//	    }
//
//	    private void errorHandling(HttpServletRequest request) {
//	        Log.warn("Wrong or empty input password and/or login");
//	        request.setAttribute(
//	                ResourceBundle.getBundle("resources").getString("param.error.login.input"),
//	                ResourceBundle.getBundle("content").getString("error.login.input.message"));
//	    }
//
//	    private void addUserToSession(HttpServletRequest request, User user) {
//	        HttpSession session = request.getSession();
//	        session.setAttribute("userID", user.getUserID());
//	    }
}


