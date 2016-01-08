package com.youxigu.ee.dbunit.testdbunit1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月8日 下午3:22:09
 */
public class StudentOpe {

	public Student findStudent(String id) {
		return null;
	}

	public boolean addStudent(Student student) {
		return true;
	}

//	protected void setUp() {
//		IDatabaseConnection connection = null;
//		try {
//			super.setUp();
//			// 本例使用postgresql 数据库
//			Class.forName("org.postgresql.Driver");
//			// 连接DB
//			Connection conn = DriverManager.getConnection("jdbc:postgresql:testdb.test", "postgres", "postgres");
//			// 获得DB 连接
//			connection = new DatabaseConnection(conn);
//			// 对数据库中的操作对象表student 进行备份
//			QueryDataSet backupDataSet = new QueryDataSet(connection);
//			backupDataSet.addTable("student");
//			file = File.createTempFile("student_back", ".xml");// 备份文件
//			FlatXmlDataSet.write(backupDataSet, new FileOutputStream(file));
//			// 准备数据的读入
//			IDataSet dataSet = new FlatXmlDataSet(new FileInputStream("student_pre.xml"));
//			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//			}
//		}
//	}
}
