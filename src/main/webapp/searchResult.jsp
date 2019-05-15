<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Search Multiple Fields</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Search Results:</h2>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("allResult");
        String size = Integer.toString(patients.size());
    %><h3>Number of patients found: <%=size%></></h3><%
    if (patients.size() !=0)
    {%>
    <table>
        <th>No.</th>
        <th>First Name</th>
        <th>Last Name</th>
        <%
            int number = 0;
            for (Patient patient : patients)
            {
                number++;
                String href = "patientInfo.html?Id=" + patient.getID();
        %>
        <tr>
            <td><%=number%></td>
            <td><a href="<%=href%>"><%=patient.getFirst()%></a></td>
            <td><a href="<%=href%>"><%=patient.getLast()%></a></td>
        </tr>
        <% }
        } else
        {%>
        <p>No patients found!</p>
        <%}%>
    </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
