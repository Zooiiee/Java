//Write a JSP program using JSTL Tags  to Display all Movies from the Database & Insert into the database table.

//DisplayMovies.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri ="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Display All Movies</title>
</head>
<body>
<h1>Display Movies</h1>
<sql:setDataSource var="myDs" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/postgres" user="postgres" password="password" />
<!-- Pass the Query -->
<sql:query var="rs" dataSource="${myDs}">Select * from Movies</sql:query>
<table border="1"> 
	<thead>
	<tr> 
		<th>MID</th>
		<th>TITLE</th>
		<th>DIRECTOR</th>
		<th>DURATION</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${rs.rows}">
		<tr>
			<td><c:out value="${row.mid}"> </c:out></td>
			<td><c:out value="${row.mname}"> </c:out></td>
			<td><c:out value="${row.director}"> </c:out></td>
			<td><c:out value="${row.duration}"> </c:out></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>


  
//InsertMovies.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri ="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert a Movie</title>
</head>
<body>
<h1>Insert into Movies Table</h1>

	<form action="AddMovie.jsp">
	<table>
		<tr>
		<td>Movie Id: </td><td><input type="text" name="mid"/></td>
		</tr>
		<tr> 
		<td>Movie Name: </td><td><input type="text" name="mname"/></td>
		</tr>
		<tr>
		<td>Movie Director: </td><td><input type="text" name="director"/></td>
		</tr>
		<tr>
		<td>Movie Duration: </td><td><input type="text" name="duration"/></td>
		</tr>
		<tr>
		<td><input type="submit" name="sub" value="Insert"/></td>
		</tr>
		</table>
	</form>

</body>
</html>



//AddMovie
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri ="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Results Page</title>
</head>
<body>
<!-- Convert String to Integer-->
<fmt:parseNumber var="intmid" value="${param.mid}"></fmt:parseNumber>
<fmt:parseNumber var="intdur" value="${param.duration}"></fmt:parseNumber>

<!-- Set Data Source -->
<sql:setDataSource var="myDs" driver="org.postgresql.Driver" url="jdbc:postgresql://localhost:5432/postgres" user="postgres" password="password" />

<!-- Pass the Query -->
<sql:update var="rowCnt" dataSource="${myDs}">
    insert into movies(mid, mname, director, duration) values (?, ?, ?, ?);
    <sql:param value="${intmid}" />
    <sql:param value="${param.mname}" />
    <sql:param value="${param.director}" />
    <sql:param value="${intdur}" />
</sql:update>

<!-- Success Message -->
<p>Movie inserted successfully!</p>
<a href ="InsertMovie.jsp">Add Another Movie</a>

</body>
</html>


  
