<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.io.File"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
File[] f = (File[])request.getAttribute("filelist");
for (File f1 : f) {
    out.print("<a target='view_window' href=/AirPlay/stream?video="+f1.getName()+">"+f1.getName()+"<a><br>");
}
%>

</body>
</html>