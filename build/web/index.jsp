<%-- 
    Document   : index
    Created on : Nov 5, 2018, 9:06:55 AM
    Author     : USERR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="article?a=undo"><button>Undo changes</button></a><br>
        <form method="POST" action="article?a=save">
            <textarea name="text" placeholder="Type your ideas here "><%= request.getAttribute("text") %></textarea>
            <button>Save</button>
        </form>
    </body>
</html>
