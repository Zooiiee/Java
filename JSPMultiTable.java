//Index.html

<!DOCTYPE html>
<html>
<head>Multiplication Table Application
<meta charset="ISO-8859-1">
<title>Multiplication Table Application</title>
</head>
<body>
	<hr>
	<form action="MultiTable.jsp">
		Enter a Number: <input type="text" name="txtNum"><br>
		<input type="submit" name="btnSubmit" value="Submit">
	</form>
</body>
</html>


  
  //MultiTable.jsp
  <%@ page language="java" errorPage="ShowError.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head></head>
<body>
	<h2>Multiplication Table</h2>
	<hr>
	<%
		//Scriptlet
		//Step 1 : Fetch the number from index.html
		String val = request.getParameter("txtNum");
		int num = Integer.parseInt(val);
		
		%>
	    <table border="1">
	        <tr>
	            <th>Multiplication Table of <%= num %></th>
	        </tr>
	     <%
		//Step 2: Loop till mul table
		for(int i = 1 ;i<=10; i++)
		{
	%>
		 <tr> <td><%= num %> * <%=i %> = <%=(num*i) %></td>
        </tr>
	<%
		}
	%>
	</table><br>
	<a href="Index.html">Print another Table</a>
</body>
</html>


//ShowError.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1>OOPS! Something went Wrong!!!<br><%=exception.getMessage() %></h1>
	<a href="Index.html">Try Again</a>
</body>
</html>
