<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Patient Info</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Patient Information:</h2>
    <table>
        <tr>
            <th>Category</th>
            <th>Info</th>
        </tr>
        <%
            List<String> patientInfo = (List<String>) request.getAttribute("patientInfo");
            for(String categories : patientInfo){
                String[] info = categories.split(":");
                String categoryName = info[0];
                String categoryValue = info[1];
        %>
        <tr>
            <td><%=categoryName%></td>
            <td><%=categoryValue%></td>
        </tr>
        <%}%>
    </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>

