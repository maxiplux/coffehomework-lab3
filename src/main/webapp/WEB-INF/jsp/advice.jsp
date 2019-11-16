<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>


<head>
<title>Starbuck's</title>
</head>
<body>
<h2>Ask for advice about your favorite roast:</h2>
<p />
<label>User: <strong>${user.name}</strong></label>

<form action="/logout" method="get">
	<input type="submit" value="Logout">
</form>

<form action = "/advice/" method="post">
<select name="roast"  >

	  		<c:forEach var="roast" items="${roasts}">
	    		<option value="${roast.value}" > ${roast.key}</option>
			</c:forEach>

</select>

<p><input type="submit" value = "Submit"/></p>
</form>
  
 </body>
</html>
