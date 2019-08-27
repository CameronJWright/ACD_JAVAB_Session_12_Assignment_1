package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;
import db.DBUtility;

/**
 * Servlet implementation class BookShopping
 */
@WebServlet("/BookShopping")
public class BookShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookShopping() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getDBInstance();
		DBUtility.useDB(con, "onlinebooks");

		String query, selectQuery;

		ResultSet rs;
		response.setContentType("text/html");


		selectQuery = "SELECT * FROM `onlinebooks`.`books`;";

		query = "INSERT INTO `onlinebooks`.`books` (`title`, `author`, `publisher`, `publication_year`, `price`) VALUES ('Green Eggs and Ham', 'Mel Gibson', 'Shakira', '1999', '$20')";
		DBUtility.executeUpdate(con, query);
		rs = DBUtility.executeQuery(con, selectQuery);
		response.getWriter().append("<h1>"+DBUtility.printEntireRS(rs)+"</h1><br/><br/>");



		query = "UPDATE `onlinebooks`.`books` SET `publisher` = 'Shaq' WHERE (`title` = 'Green Eggs and Ham');";
		DBUtility.executeUpdate(con, query);
		rs = DBUtility.executeQuery(con, selectQuery);
		response.getWriter().append("<h1>"+DBUtility.printEntireRS(rs)+"</h1><br/><br/>");


		query = "DELETE FROM `onlinebooks`.`books` WHERE (`title` = 'Green Eggs and Ham');";
		DBUtility.executeUpdate(con, query);
		rs = DBUtility.executeQuery(con, selectQuery);
		response.getWriter().append("<h1>"+DBUtility.printEntireRS(rs)+"</h1><br/><br/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
