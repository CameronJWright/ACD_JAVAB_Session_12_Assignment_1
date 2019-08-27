<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter the Book information</h1>
	<br/>
	<h2>Insert</h2>
	<form action="BookShopping" method="post">
							<input type="hidden" name="type" value="insert">
		Title:    			<input type="text" name="title"> 
		Author:     		<input type="text" name="author"> 
		Publisher:      	<input type="text" name="publisher"> 
		Publication Year:	<input type="text" name="publicationYear"> 
		Price:         		<input type="text" name="price"> 
		<input type="submit" value="Insert Book">
	</form>
	<br/>
	<h2>Update Publisher</h2>
	<form action="BookShopping" method="post">
							<input type="hidden" name="type" value="update">
		Title:    			<input type="text" name="title"> 
		Publisher:      	<input type="text" name="publisher">  
		<input type="submit" value="Update Book">
	</form>
	<br/>
	<h2>Delete</h2>
	<form action="BookShopping" method="post">
							<input type="hidden" name="type" value="delete">
		Title:    			<input type="text" name="title">
		<input type="submit" value="Delete Book">
	</form>
</body>
</html>