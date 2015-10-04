package by.academy;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.academy.cfg.Beans;
import by.academy.cfg.DaoCfg;
import by.academy.dao.CriminalDao;
import by.academy.dao.CustomCriminalDao;
import by.academy.dao.CustomEventDao;

import by.academy.dao.EventDao;
import by.academy.dao.interf.CriminalService;
import by.academy.dto.CriminalDto;
import by.academy.dto.EventDto;
import by.academy.dto.EventTypeDto;
import by.academy.dto.RoleDto;
import by.academy.dto.UserDto;
import by.academy.dto.UserRoleDto;
import by.academy.hbutil.ConvertDate;
import by.academy.service.cfg.ServiceCfg;
import by.academy.service.interf.UserService;


/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger = LogManager.getLogger(App.class.getName());
	public static void main(String[] args)  {
		
	    ApplicationContext context = new AnnotationConfigApplicationContext(ServiceCfg.class, Beans.class);
	    		
	//	CriminalService cs=context.getBean(CriminalService.class);
//		Criminal crim=new Criminal();
//		crim.setCriminalName("Vini-PUH-pug");
//		crim.setCriminalSurname("pig is he");
//		cs.addCriminal(crim);
		
//		UserService us=context.getBean(UserService.class);
//		us.getUserByName("Admin");
		
	}
/*        CriminalService criminalService= new CriminalServiceImpl();
        CustomCriminalDao criminalDao=new CriminalDao();
		criminalService.setCriminalDao(criminalDao);  
        System.out.println(criminalService.getCriminals());
        
        UserServiceImpl userservice=new UserServiceImpl();
        CustomUserDao userDao=new UserDao();
        userservice.setUserDao(userDao);  
        userservice.authorization("Admin", "1223");*/
        
   //     CustomEventDao eDao= new EventDao();
//        EventService es=new EventServiceImpl();
//         Date d = null;
//        CriminalDto  cdto = new CriminalDto(1, "Ganstrelitto", "De la Vorro", d);
//        
//        RoleDto rdto =new RoleDto (999,"Admin");
//        Set rolesDto = new HashSet();
//        rolesDto.add(rdto);
//        UserRoleDto  udto = new UserRoleDto(999, "Admin", rolesDto);
//        EventTypeDto tdto = new EventTypeDto(1,"Draka");
//    	Calendar cal = Calendar.getInstance();
//        cal.set(2015, Calendar.AUGUST, 30);
//        java.util.Date date = cal.getTime();
//        java.sql.Date sqlDate = ConvertDate.convert(date); 
//        
//        EventDto edto=new EventDto("Event #6", "bla- bla", sqlDate, (Integer)1, (Integer)1, (Integer)1);
        
     //   es.setEventDao(eDao);
//        es.add(edto);
//        System.out.println( "---" );
   // }
}
