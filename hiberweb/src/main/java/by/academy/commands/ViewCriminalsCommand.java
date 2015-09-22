package by.academy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.service.impl.CriminalServiceImpl;
import by.academy.service.interf.CriminalService;

public class ViewCriminalsCommand implements ICommands {
	public static Logger logger = LogManager.getLogger(ViewCriminalsCommand.class.getName());
	private CriminalService criminalService=null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		logger.info("execute start");
		String page = "/WEB-INF/view/criminallist.jsp";
		try {

	        CriminalService criminalService= new CriminalServiceImpl();
			request.setAttribute("criminals", criminalService.getCriminals());
			logger.info("get criminals list:" + criminalService.getCriminals());
		} catch (Exception e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}

		return page;
	}
}
