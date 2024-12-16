//CounterCookie.jsp

<%@ page language="java" %>
<html>
  <body>
  <%! Cookie[] cookies; %>
    <%
      // Retrieve all cookies from the request
      cookies = request.getCookies();

      // Check if cookies exist
      if (cookies == null) {
        // First visit: Create a new cookie
        Cookie c1 = new Cookie("cnt", "1");
        out.println("<h1>This is your first visit!</h1>");
        // Add the new cookie to the response
        response.addCookie(c1);
      } else {
        // Not the first visit: Check existing cookies
        for (int i = 0; i < cookies.length; i++) {
          Cookie temp = cookies[i];
          if (temp.getName().equals("cnt")) {
            // Fetch the old value and increment it
            int val = Integer.parseInt(temp.getValue());
            val = val + 1;
            out.println("<h1>This is your visit number: " + val+"</h1>");

            // Update the cookie with the new value
            Cookie updated = new Cookie("cnt", "" + val);
            //updated.setMaxAge(24 * 60 * 60); // Set cookie expiration time to 1 day
            response.addCookie(updated);
          }
        }
      }
    %>
  </body>
</html>
