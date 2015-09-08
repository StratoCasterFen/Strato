package by.academy.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.dao.CriminalDao;
import by.academy.service.impl.CriminalService;

public class ViewCriminalsCommand implements ICommands {
	public static Logger logger = LogManager.getLogger(ViewCriminalsCommand.class.getName());

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		logger.info("execute start");
		String page = "/WEB-INF/view/criminallist.jsp";
		try {
			CriminalDao criminalDao=new CriminalDao();
	        CriminalService criminalService= new CriminalService();
			criminalService.setCriminalDao(criminalDao);  

			request.setAttribute("criminals", criminalService.getCriminals());
			logger.info("get criminals list:" + criminalService.getCriminals());
		} catch (Exception e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}

		return page;
	}
}
