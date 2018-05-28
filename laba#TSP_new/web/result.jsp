<%@ page import="pack.Task" %><%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 07.05.2018
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Task task = (Task) request.getSession().getAttribute("task");
    if (task == null) {
        response.setHeader("Refresh", "5; URL=index.jsp");
    }

%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Результат</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Результат</h1>
<table>
    <tr>
        <td>
            <table>
                <tr>
                    <td>
                        <% if(task!= null) { %>


                        <p>Найдём подстроку <%=task.getB()%> в строке <%=task.getA()%>:</p>

                        <p>Данная подстрока встречается в строке <%=task.getResult()%> раз!</p>

                            <input type="button" value="Получить xml" onClick='location.href="result.xml"'>



                        <input type="button" value="Повторить" onClick='location.href="index.jsp"'>
                        <% }
                        else {%>

                        <h1>
                            Вы будете перенаправлены на <a href="index.jsp">index.jsp</a> </h1>
                        <img src="sad.png">

                        <% }%>
                    </td>
                </tr>

            </table>
        </td>

    </tr>
</table>



</body>
</html>
