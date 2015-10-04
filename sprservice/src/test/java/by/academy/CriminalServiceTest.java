//package by.academy;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Calendar;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.junit.Before;
//import org.junit.Test;
//
//import by.academy.dto.CriminalDto;
//import by.academy.hbutil.ConvertDate;
//import by.academy.pojos.Criminal;
//import by.academy.service.exeption.ServiceException;
//import by.academy.service.impl.CriminalServiceImpl;
//import by.academy.service.interf.CriminalService;
//
//
//public class CriminalServiceTest {
//	static Logger logger = Logger.getLogger(CriminalServiceTest.class.getName());
//
//	private CriminalService crimServ;
//
//	private CriminalDto crimDto;
//	
//	@Before
//	public void setUp() throws ServiceException{
//		logger.info("setup before test");
//		Calendar cal = Calendar.getInstance();
//		cal.set(1975, Calendar.AUGUST, 10);
//        java.util.Date date = cal.getTime();
//        java.sql.Date sqlDate = ConvertDate.convert(date);   
//		crimServ = new CriminalServiceImpl();
//		crimDto = new CriminalDto(5, "Bambarbiya", "Kergudusha", date);
//	}	
//	
//	@Test
//	public void getCriminalById() throws ServiceException {
//		Criminal crim = crimServ.getCriminalById(2);
//		assertEquals(Criminal.class, crim.getClass());
//	}
//	
//	@Test
//	public void addDeleteCriminal() throws ServiceException {
//		logger.info("addCriminal");
//		crimServ.addCriminal(crimDto);
//		crimServ= new CriminalServiceImpl();
//		logger.info("delCriminal");
//	//	crimServ.deleteById(3);
//		
//		//assertEquals(null, );
//	}
//	
//	@Test
//	public void updateCriminal() throws ServiceException {
//		logger.info("updateCriminal");
//		crimServ.updateCriminal(crimDto);
//		//assertEquals(null, user);
//	}
//	
//	@Test
//	public void getCriminals() throws ServiceException {
//		logger.info("getCriminals");
//		List crims = crimServ.getCriminals();
//		logger.info(crims);
//	//	assertEquals(4l, crims.size());
//	}
//}
