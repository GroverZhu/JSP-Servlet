package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BeerExpert {

	public List<String> getBrands(String color) throws ClassNotFoundException {
		Connection connection = null;
		List<String> brands = new ArrayList<String>();
		try {
			connection = AccessJDBCUtil.getConnection();
			Statement statement = connection.createStatement();

			// 根据所选的颜色来获取数据库中的值
			if (color.equals("light")) {
				String querySql = "select name from beer where color = 'light'";
				ResultSet rs = statement.executeQuery(querySql);
				while (rs.next()) {
					brands.add(rs.getString("name"));
				}
			} else if (color.equals("amber")) {
				String querySql = "select name from beer where color = 'amber'";
				ResultSet rs = statement.executeQuery(querySql);
				while (rs.next()) {
					brands.add(rs.getString("name"));
				}
			} else if (color.equals("brown")) {
				String querySql = "select name from beer where color = 'brown'";
				ResultSet rs = statement.executeQuery(querySql);
				while (rs.next()) {
					brands.add(rs.getString("name"));
				}
			} else {
				String querySql = "select name from beer where color = 'dark'";
				ResultSet rs = statement.executeQuery(querySql);
				while (rs.next()) {
					brands.add(rs.getString("name"));
				}
			}
			return brands;
		} catch (SQLException s) {
			System.out.println(s);
			return null;

		} finally  {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ignore) {
					
				}
			}
		}
	}
}
