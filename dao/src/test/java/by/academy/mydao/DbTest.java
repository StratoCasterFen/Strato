package by.academy.mydao;

//import java.io.FileInputStream;
//
//import org.dbunit.DBTestCase;
//import org.dbunit.PropertiesBasedJdbcDatabaseTester;
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
//import org.dbunit.operation.DatabaseOperation;
//
//public class Dbtest extends DBTestCase	{
//	public Dbtest(String name) {
//		super(name);
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
//				"jdbc:mysql://localhost:3306/policestation");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "qwe321");
//	}
//
//	protected IDataSet getDataSet() throws Exception {
//		return new FlatXmlDataSetBuilder().build(new FileInputStream("policetest.xml"));
//	}
//
//	protected DatabaseOperation getSetUpOperation() throws Exception {
//		return DatabaseOperation.REFRESH;
//	}
//
//	protected DatabaseOperation getTearDownOperation() throws Exception {
//		return DatabaseOperation.NONE;
//	}
//
//}

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;

import by.academy.mysql.MySqlUserDao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.sql.DataSource;
import static org.junit.Assert.assertNotNull;


@RunWith(UnitilsJUnit4TestClassRunner.class)
public class DbTest {
	static Logger logger= Logger.getLogger(DbTest.class.getName());
	{logger.info("+Start DBTest");}
	
	@TestDataSource
	private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
    	logger.debug("+Before");
    	MySqlUserDao userdao = new MySqlUserDao(dataSource.getConnection());
    }

    @DataSet
    @Test
    public void testGetUsers() throws Exception {
    
		logger.debug("+testGetUsers");

		Connection cnnx = dataSource.getConnection();
		Statement stmt = cnnx.createStatement();

		ResultSet rs = null;
		try {

			rs = stmt.executeQuery("SELECT * FROM users");
			logger.info("testGetUsers succeeded");
			System.out.println("testGetUsers succeeded");

		} finally {
			if (rs != null) {
				rs.close();
			}
		}

		stmt.close();
		cnnx.close();
    }
}