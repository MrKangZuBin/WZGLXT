<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>国际化的页面</title>
</head>
<body>
    <a href="/day12/login.jsp?language=zh">中文（网页）</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/day12/login.jsp?language=en">English（pages）</a>

    <%
        String language = request.getParameter("language");
        if(language == null || language.equals("")) {
            language = "zh";
        }   
        Locale locale = new Locale(language); // Locale代表当前语言地区和国家

        ResourceBundle bundle = ResourceBundle.getBundle("cn.itcast.resource.MessageResource",locale);
    %>
    <form action="">
        <%=bundle.getString("username") %><input type="text" name="username"><br/>
        <%=bundle.getString("password") %><input type="password" name="password"><br/>
        <input type="submit" value="<%=bundle.getString("submit") %>">
    </form>
</body>
</html>