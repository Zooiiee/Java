//1.Create a Login Application with Bean

//UserBean.java

package edu.met.p1;
public class UserBean {
	
	private String uname;
	private String password;
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UserBean() {
		// TODO Auto-generated constructor stub
		
	}

	//validate to check uname and password
	public boolean validate()
	{
		if(this.uname.equals("Shanti") && this.password.equals("1234"))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}



//Login.jsp

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login Application</title>
</head>
<body>
	<h2>Login Page</h2>
		<hr>
		<table border="1">
	            <form action="CheckLogin.jsp">
				<tr><td>Enter Username : </td>
				<td><input type="text" name="uname"></td>
				</tr>
				<tr><td>Enter Password : </td>
				<td><input type="password" name="password"></td>
				</tr>
				<tr>
				<td><input type="reset" name="btnReset" value="Reset"></td>
				<td><input type="submit" name="btnSub" value="Login"></td>
				</tr>
				</form>
	      </table>
</body>
</html>



//CheckLogin.jsp

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<body>
	<jsp:useBean id="userBean" class="edu.met.p1.UserBean"/>
	<jsp:setProperty property="*" name="userBean"/>

	<%
		if(userBean.validate())
		{
	%>
			<jsp:forward page="Welcome.jsp"/>
	<%
		}
		else
		{
	%>
			<jsp:forward page="InvalidUser.jsp"/>
	<%
		}
	%>
</body>
</html>


//Welcome.jsp

<h1><i>Welcome <%= request.getParameter("uname") %> </i></h1>


//InvalidUser.jsp

<h1><i>Incorrect Username or Password!!</i></h1>
<a href="Login.jsp">Try Again!</a>


