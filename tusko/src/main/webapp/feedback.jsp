<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Font Awesome Icon Library -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>FeedBack Us</h2>
	<form action="./addFeedback">
		<pre>
Name:<input type="text" name="name"><br>

Email:<input type="text" name="email"><br>

Select:<select name="reg">
<option value="website">website</option>
<option value="onlineCources">onlineCources</option>
<option value="faceBook">faceBook</option>
</select><br>

Code:<input type="number" name="code"><br>

Message:<input type="text" name="message" />

Rating:<input type="number" name="rating" />

<input type="submit" value="Submit">

<input type="reset" value="Reset">
</pre>
	</form>
</body>
</html>