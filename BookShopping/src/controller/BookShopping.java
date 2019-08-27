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

		String query, selectQuery, type, title, author, publisher, publicationYear, price;

		type = (String) request.getParameter("type");
		title = (String) request.getParameter("title");
		author = (String) request.getParameter("author");
		publisher = (String) request.getParameter("publisher");
		publicationYear = (String) request.getParameter("publicationYear");
		price = (String) request.getParameter("price");

		ResultSet rs;
		response.setContentType("text/html");

		selectQuery = "SELECT * FROM `onlinebooks`.`books`;";

		if (type.equals("insert")) {
			query = "INSERT INTO `onlinebooks`.`books` (`title`, `author`, `publisher`, `publication_year`, `price`) VALUES ('"
					+ title + "', '" + author + "', '" + publisher + "', '" + publicationYear + "', '" + price + "')";
			if (DBUtility.executeUpdate(con, query)) {
				rs = DBUtility.executeQuery(con, selectQuery);
				response.getWriter().append("<h3>" + DBUtility.printEntireRS(rs) + "</h3>");
			} else
				response.getWriter().append("<meta http-equiv='refresh' content='2;URL=BookShopping.jsp'><h1 style='color:red;'>Book Not Inserted!</h1>");
		} else if (type.equals("update")) {
			query = "UPDATE `onlinebooks`.`books` SET `publisher` = '" + publisher + "' WHERE (`title` = '" + title
					+ "');";
			if (DBUtility.executeUpdate(con, query)) {
				rs = DBUtility.executeQuery(con, selectQuery);
				response.getWriter().append("<h3>" + DBUtility.printEntireRS(rs) + "</h3>");
			} else
				response.getWriter().append("<meta http-equiv='refresh' content='2;URL=BookShopping.jsp'><h1 style='color:red;'>Book Not Updated!</h1>");
		} else if (type.equals("delete")) {
			query = "DELETE FROM `onlinebooks`.`books` WHERE (`title` = '"+title+"');";
			if (DBUtility.executeUpdate(con, query)) {
				rs = DBUtility.executeQuery(con, selectQuery);
				response.getWriter().append("<h3>" + DBUtility.printEntireRS(rs) + "</h3>");
			} else
				response.getWriter().append("<meta http-equiv='refresh' content='2;URL=BookShopping.jsp'><h1 style='color:red;'>Book Not Deleted!</h1>");
		} else
			response.getWriter().append("<h1 style='color:red>Someone Done goofed!</h1>");

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
