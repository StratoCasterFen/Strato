package by.academy;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.academy.cfg.DBConnection;
import by.academy.dao.interf.CriminalService;
import by.academy.pojos.Criminal;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConnection.class)
//@WebAppConfiguration
public class CriminalServiceTest {
	 private Logger Log = LogManager.getLogger(CriminalServiceTest.class.getName());
	 
	 @Resource
	    private EntityManagerFactory emf;
	    protected EntityManager em;
	    private Criminal crim;
	 
	    @Resource
	    private CriminalService criminalService;
	 
	    @Before
	    public void setUp() throws Exception {
	        em = emf.createEntityManager();
	    }
	 
	    @Test
	    public void testSaveBank() throws Exception {
	    	crim=new Criminal();
	    	crim.setCriminalName("BIBABO");
	    	crim.setCriminalSurname("Chikalo");
	    	Criminal actual=criminalService.addCriminal(crim);
	    	Assert.assertEquals(Criminal.class, actual);
	    }
}
