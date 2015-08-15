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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.dbunit.annotation.DataSet;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.sql.DataSource;
//import java.util.List;

import static org.junit.Assert.assertNotNull;

//@DataSet
//@RunWith(UnitilsJUnit4TestClassRunner.class)
//public class MysqlDAOTest {

//    @TestDataSource
//    private DataSource dataSource;
//
//    //private LanguageDAO dao;
//
//    @Before
//    public void setUp() throws Exception {
//	//dao = new LanguageDAOOracleImpl1(dataSource);
//    }
//
//    @Test
//    public void testGetUsers() throws Exception {
//    
//        System.out.println("testGetUsers");
//        
//        Connection cnnx = dataSource.getConnection();
//        Statement stmt = cnnx.createStatement();
//        
//        ResultSet rs = null;
//        try {
//            // check that the GG_LANGUAGES1 table exists
//            rs = stmt.executeQuery("SELECT * FROM users");
//
//            // check that the GG_POC table exists
//            rs = stmt.executeQuery("SELECT * FROM roles");
//
//            System.out.println("testGetUsers succeeded");
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//        }
//        stmt.close();
//        cnnx.close();
//        
//    }
//}