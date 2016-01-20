package com.youxigu.ee.dbunit;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DBTestCase;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.CachedDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.xml.XmlProducer;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.FileHelper;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月8日 上午11:27:42
 */
public class AnimalsTest extends DBTestCase {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youxigu", "root", "root");
//		DatabaseConnection conn = new DatabaseConnection(connection);
//		DatabaseConfig config = conn.getConfig();
//		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
//		QueryDataSet set = new QueryDataSet(conn);
//		set.addTable("person");// 作用相当于SELECT * FROM tableName
//		// set.addTable("animals", "select * from animals limit
//		// 4");//相当于增加了查找的条件
//		FlatXmlDataSet.write(set, new FileWriter(new File("dbunit.xml")), "UTF-8");
//		new AnimalsTest().getDataSet();
//		boolean enableColumnSensing = true;
//		FlatXmlDataSet dataSet = new FlatXmlDataSet(new File("D:/Develop/Eclipse_Mars/workspace/7q_mobile_2.7/data/zh_CN/Caddy.xml"), false, enableColumnSensing);
		XmlProducer producer = new XmlProducer(FileHelper.createInputSource(new File("D:/Develop/Eclipse_Mars/workspace/7q_mobile_2.7/data/zh_CN/Caddy.xml")));
		CachedDataSet set = new CachedDataSet(producer);
		DatabaseConnection databaseConnection = new DatabaseConnection(connection);
		DatabaseOperation cleanInsert = DatabaseOperation.CLEAN_INSERT;
		DatabaseOperation.TRANSACTION(cleanInsert);
		cleanInsert.execute(databaseConnection, set);
		DatabaseOperation.CLOSE_CONNECTION(cleanInsert);
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().setColumnSensing(true).build(new FileInputStream("D:/Develop/Eclipse_Mars/workspace/7q_mobile_2.7/data/zh_CN/Caddy.xml"));
	}
}
