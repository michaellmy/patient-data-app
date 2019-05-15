<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Statistics</title>
    <style>
        #info{
            display: grid;
            grid-template-columns: 1fr 1fr;
        }
    </style>
</head>

<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>General Statistics:</h2>
        <%
            List<String> statistics = (List<String>) request.getAttribute("statistics");
            for(String stats : statistics){
                String[] temp = stats.split(":");
        %>
    <div id="info">
        <p><%=temp[0]+":"%></p>
        <p><%=temp[1]%></p>
    </div>
        <% } %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>