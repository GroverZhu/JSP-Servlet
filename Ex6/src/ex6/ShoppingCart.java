package ex6;

import javax.servlet.*;
import javax.servlet.http.*;

import model.AccessJDBCUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 取得Session对象
		// 如果Session不存在，为本次会话创建此对象
		HttpSession session = req.getSession(true);
		Integer itemCount = (Integer) session.getAttribute("itemCount");
		// 如果session是新的
		if (itemCount == null)
			itemCount = new Integer(0);

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		// 接收传来的参数
		String[] itemsSelected;
		String itemName;
		itemsSelected = req.getParameterValues("item");

		// 将传来的参数存在session中
		if (itemsSelected != null) {
			for (int i = 0; i < itemsSelected.length; i++) {
				itemName = itemsSelected[i];
				System.out.println(itemName);
				itemCount = new Integer(itemCount.intValue() + 1);
				// 购买的条目
				session.setAttribute("item" + itemCount, itemName);
				// 总条目
				session.setAttribute("itemCount", itemCount);
			}
		}
		// 获取session中的所有beer name
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 1; i <= itemCount.intValue(); i++) {
			names.add((String) session.getAttribute("item" + i));
		}
		// 使用map合并session中的重复的beer 
		// 根据beer name从数据库中获取详细消息， 并将数据存储在Beer对象中
		ArrayList<Beer> beerList = new ArrayList<Beer>();
		// 统计相同的beer的数据
		HashMap<String, Integer> beerMap = new HashMap<String, Integer>();
		for (String beer : names) {
			if (beerMap.get(beer) == null) {
				beerMap.put(beer, 1);
			} else {
				Integer count = beerMap.get(beer);
				count++;
				beerMap.put(beer, count);
			}
		}
		try {
			// 重数据库中获取数据并写入Beer对象中
			Connection connection = AccessJDBCUtil.getConnection();
			String query = "select * from beer where name = ?";
			PreparedStatement querySql = connection.prepareStatement(query);
			Iterator iterator = beerMap.keySet().iterator();
			while (iterator.hasNext()) {
				String beerName = (String) iterator.next();
				Integer count = beerMap.get(beerName);
				querySql.setString(1, beerName);
				ResultSet rs = querySql.executeQuery();
				if (rs.next()) {
					int id = rs.getInt("id");
					String manufacture = rs.getString("manufacture");
					String color = rs.getString("color");
					Beer beer = new Beer(id, beerName, manufacture, color, count);
					beerList.add(beer);
				}

			}
			// 关闭数据库连接
			connection.close();
			req.setAttribute("beerlist", beerList);
			RequestDispatcher view = req.getRequestDispatcher("shopCart.jsp");
			view.forward(req, res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// 打印到控制台调试
		for (Beer beer : beerList) {
			System.out.println("-*-" + beer.getId() + beer.getName() + beer.getManufacture() + beer.getColor()
					+ beer.getCount() + "-*-\n");
		}
//		out.println("<html>");
//		out.println("<title>");
//		out.println("item list");
//		out.println("</title>");
//		out.println("<body><h4>Session List:</h4><hr><br><br>");
//		for (int i = 1; i <= itemCount.intValue(); i++) {
//			out.println((String) session.getAttribute("item" + i) + "<hr>");
//		}
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
	}
}