<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>PrintQuestion Page</h1>
<form action="./getNextQuestion">
<h1>${questions.qid}.${questions.que}</h1>
<input type="hidden" name="qid" value="${questions.qid}">
<input type="radio" name="ans" value="${questions.opt1}">${questions.opt1}
<input type="radio" name="ans" value="${questions.opt2}">${questions.opt2}
<input type="radio" name="ans" value="${questions.opt3}">${questions.opt3}
<input type="radio" name="ans" value="${questions.opt4}">${questions.opt4}
<br>
<br>
<br>
<input type="submit" value="Next">  </form> 

</body>

</html>