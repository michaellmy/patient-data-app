<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>Search By Age</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Age Search Results:</h2>
    <%
        List<Patient> patients = (List<Patient>) request.getAttribute("ageResult");
        String size = Integer.toString(patients.size());

        String averageAge = (String) request.getAttribute("averageAge");
        String youngest = (String) request.getAttribute("youngest");
        String oldest = (String) request.getAttribute("oldest");
        String males = (String) request.getAttribute("males");
        String females = (String) request.getAttribute("females");
    %>
    <h3>Number of patients found: <%=size%></></h3><%
        if (patients.size() !=0)
        {
        %><ul>
            <li>Average age: <%=averageAge%> years old</li>
            <li>Youngest Patient: <%=youngest%> years old</li>
            <li>Oldest Patient: <%=oldest%> years old</li>
            <li>Number of males: <%=males%> patients</li>
            <li>Number of females: <%=females%> patients</li>
        </ul>

    <h3>Patients: </h3>
    <table>
        <th>No.</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <%
            int number = 0;
            for (Patient patient : patients)
            {
                number ++;
                String href = "patientInfo.html?Id=" + patient.getID();
        %>
        <tr>
            <td><%=number%></td>
            <td><a href="<%=href%>"><%=patient.getFirst()%></a></td>
            <td><a href="<%=href%>"><%=patient.getLast()%></a></td>
            <td><%=patient.getAge()%> </td>
        </tr>
        <%  }
        } else
        {%>
        <p>No patients found!</p>
        <%}%>
    </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>