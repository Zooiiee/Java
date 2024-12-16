//add the postgree lib also copy paste the jar into lib folder
//Login.jsp

<%@ page language="java" %>
<html>
	<head>
		<title>Login Application</title>
	</head>
	<body>
		<h2>Login Page</h2>
		<hr>
		<table border="1">
	            <form action="CheckLoginDB.jsp">
				<tr><td>Enter Username : </td>
				<td><input type="text" name="txtUname"></td>
				</tr>
				<tr><td>Enter Password : </td>
				<td><input type="password" name="txtPwd"></td>
				</tr>
				<tr>
				<td><input style="display: block; margin: 0 auto;" type="reset" name="btnReset" value="Reset"></td>
				<td><input style="display: block; margin: 0 auto;" type="submit" name="btnSub" value="Submit"></td>
				</tr>
				</form>
	      </table>	
	</body>
</html>


//welcome.jsp
<h1>Welcome <%= request.getParameter("txtUname") %></h1>

//invaliduser.jsp
<h1>Incorrect Username or Password!!</h1>
<a href="Login.jsp">Try Again</a>



//CheckLogin.jsp

<%@ page language="java" %>
<html>
	<body>
		<%
			//fetch username & password
			String un = request.getParameter("txtUname");
			String pwd = request.getParameter("txtPwd");
			
			//check for un and pwd
			if(un.equals("Priya") && pwd.equals("12345"))
			{
		%>		
				<jsp:forward page="Welcome.jsp"></jsp:forward>
		<%
			}
			else
			{			
		%>
				<jsp:forward page="InvalidUser.jsp"></jsp:forward>
		<%
			}
		%>
	</body>
</html>



//CheckloginDb
<%@ page language="java" import="java.sql.*" %>
<html>
	<body>
		<%
			//1. Load the Driver
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException ex) {
				out.println("Driver not found: " + ex.getMessage());
			}

			try {
				//2. Create a Connection
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");

				// Fetch username & password
				String un = request.getParameter("txtUname");
				String pwd = request.getParameter("txtPwd");

				//3. Use PreparedStatement
				String sql = "SELECT * FROM users WHERE uname = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, un);
				// Step 4: Execute the Query
				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					// Compare username and password
					if (un.equalsIgnoreCase(rs.getString("uname").trim()) &&
					    pwd.equals(rs.getString("pwd").trim())) { // Replace password_column_name
		%>
						<jsp:forward page="Welcome.jsp"></jsp:forward>
		<%
					} else {
		%>
						<jsp:forward page="InvalidUser.jsp"></jsp:forward>
		<%
					}
				} else {
		%>
					<jsp:forward page="InvalidUser.jsp"></jsp:forward>
		<%
				}

			} catch (SQLException ex) {
				out.println("Database error: " + ex.getMessage());
			}
		%>
	</body>
</html>
