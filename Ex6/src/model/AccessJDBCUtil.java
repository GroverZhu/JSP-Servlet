package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessJDBCUtil {

	// 定义连接数据库所需的参数
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/ex6";
	private static final String USER = "postgres";
	private static final String PASSWORD = "123456";

	private static Connection connection = null;

	// 访问数据库为串行化
	public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
		// 利用Java反射机制来获取数据库驱动
		Class.forName(DRIVER);
		// 获取连接
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		return connection;
	}

}
