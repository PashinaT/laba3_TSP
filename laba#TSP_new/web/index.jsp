<%@ page import="pack.Task" %><%--
  Created by IntelliJ IDEA.
  User: Tanya
  Date: 30.04.2018
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String a=request.getParameter("str1");//возвращает параметры http-запроса. Они передаются от клиента к серверу
    String b=request.getParameter("str2");
    boolean tutu1=false;
    boolean tutu2=false;
    if(a != null || b != null)
    {
        tutu1=a.isEmpty();
        tutu2=b.isEmpty();
        if (!tutu1 && !tutu2)
        {
            session.setAttribute("task",new Task(a,b));
            response.sendRedirect("result.html");// В этом методе WEB-приложение возвращает ответ клиенту со статусом кода 302 (redirect) и с ссылкой для отправки запроса
        }

    }



    %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Лабораторная работа</title>
  <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body >
<h1> Поиск вхождения второй строки в первую  </h1>
<form method="post" action="index.jsp">
<table cellspacing="10" border="5px">
  <tr>

    <td>
      <table>
        <tr>
          <td>
            <p>Введите строку</p>
          </td>
          <td>
            <input type="text" name=str1 value="${param.str1}" onfocus="this.className='focus'" onblur="this.className='text'" placeholder="Введите строку">
              <%if(tutu1)
              {%> Пустая строка 1<%}%>
          </td>
        </tr>
        <tr>
          <td>
            <p>Введите подстроку</p>
          </td>
          <td>
            <input type="text" name=str2 value="${param.str2}" onfocus="this.className='focus'" onblur="this.className='text'" placeholder="Введите подстроку">
              <%if(tutu2)
              {%> Пустая строка 2<%}%>
          </td>

        </tr>
        <tr>
          <td>
              <input type="submit" value="Хочу результат" >


          </td>
        </tr>

      </table>
    </td>

    <td>
      <img src="pen.png" align="right">
    </td>

  </tr>


</table>


</form>
</body>
</html>
