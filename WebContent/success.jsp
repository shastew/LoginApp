<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="org.koushik.javabrains.dto.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Success</title>

<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>
<body>

<h3>Login Successful!</h3>

<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request">
    <jsp:setProperty property="userName" name="user" value="NewUser" />
</jsp:useBean>

Hello <jsp:getProperty property="userName" name="user" />!

</body>
</html>