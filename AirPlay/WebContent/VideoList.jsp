<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.File"
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>电影列表</title>
</head>
<body>
<marquee id="affiche" align="left" behavior="scroll"  direction="left"  loop="-1" scrollamount="10" scrolldelay="200" onMouseOut="this.start()" onMouseOver="this.stop()">
 



<% 
File[] f = (File[])request.getAttribute("VideoList");
for (File f1 : f) {
    out.print("<a target='view_window' href=/AirPlay/stream?video="+f1.getName()+">"+f1.getName()+"<a><br>");
}

%>
</marquee>
</body>
</html>