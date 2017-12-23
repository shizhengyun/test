<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH-Test</title>
<script type="text/javascript">
function showDiv() {
	alert("I am an alert box!!");
}

</script>
</head>
<body>
<b>Users Register</b>
	<form action="execute" method="post">
		<input type="text" name="user.username"><br /> 
		<input type="text" name="user.password"><br /> 
		<input  type="submit" onclick="return showDiv();" value="register">
	</form>
	</br>
	 <a href="http://localhost:8080/test/main.jsp">Result Page</a>

</body>
</html>