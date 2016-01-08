package com.youxigu.ee.dbunit.testdbunit2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.DBTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月8日 下午4:53:14
 */
public class MemberDaoTest extends DBTestCase {

	IMemberDao dao = new MemberDao();

	public MemberDaoTest() {
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,
//				"jdbc:mysql://localhost:3306/youxigu?useUnicode=true&characterEncoding=UTF-8");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
//		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "root");
//		String property = System.getProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL);
		DatabaseConnection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youxigu?useUnicode=true&characterEncoding=UTF-8", "root", "root");
			conn = new DatabaseConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DatabaseConfig config = conn.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().setColumnSensing(true).build(new FileInputStream("D:/Develop/Eclipse_Mars/workspace/YouXiGuLearn/src/main/java/com/youxigu/ee/dbunit/testdbunit2/MemberSet.xml"));
	}

	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}

	@Override
	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	
	@Test
	public void testSpringHibernate3Template(){
		List<Member> members = new MemberDao().listAllMember();
		for (Member member : members) {
			System.out.println(member);
		}
	}
}
