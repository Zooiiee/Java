//CounterUsingSession.jsp

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<%! int cnt=0; %>
	Session Id:  <%= session.getId() %>
	<%
		//Display
		if(session.getAttribute("cntr")==null)
		{
			//1)Create Session Attribute
			session.setAttribute("cntr", "1");
			//2)Display Message
			out.println("<h1>This is Your First Visit!</h1>");
		}
		else
		{
			//3)Fetch the old value of counter
			cnt=Integer.parseInt(session.getAttribute("cntr").toString());
			//4)Increment and Display
			cnt=cnt+1;
			out.println("<h1>This is Your Visit Number: "+(cnt)+"</h1>");
			//5)Update the counter
			session.setAttribute("cntr", ""+cnt);
		}
	%>
</body>
</html>
