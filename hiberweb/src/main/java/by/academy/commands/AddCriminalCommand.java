package by.academy.commands;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.academy.dto.CriminalDto;
import by.academy.service.exeption.ServiceException;
import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.interf.CriminalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AddCriminalCommand implements ICommands {
	public static Logger logger = LogManager.getLogger(AddCriminalCommand.class.getName());
	
	private CriminalService criminalService; 

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("execute start");
		String page = null;
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String birthday = request.getParameter("birthday");
		
		SimpleDateFormat parseDate = new SimpleDateFormat("dd.MM.yyyy");

		Date date;
		try {
			date = (Date) parseDate.parse(birthday);
		} catch (ParseException e1) {
			date=null;
			e1.printStackTrace();
		}
		
		
		try {
			criminalService = new CriminalServiceImpl();
			CriminalDto criminalDto = new CriminalDto(null, name, surname, date);
			criminalService.addCriminal(criminalDto);

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/WEB-INF/view/addcriminal.jsp";
	}

}
