<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <html>
<head>
<style type="text/css">
b{color:navy; background-color: orange;}  
</style>
<<<<<<< HEAD
<title>USERS     </title>
=======
<title>USERS</title>
>>>>>>> parent of 8a0e353... test
</head>
<body>
 <b>List of Users</b>
   <table border="1">
       <tr>
          <td><b>username</b></td>
          <td><b>password</b></td>
      
       </tr>
   <s:iterator value="users"> 
          <tr>
             <td><s:property value="username"/></td>
             <td><s:property value="password"/></td>

            </tr>
       </s:iterator>
       </table>
        </body>
</html>