<%@ page import="java.util.List" %>
<%@ page import="uk.ac.ucl.model.Patient" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient List</title>
  <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>

<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h2>Search First Names Starting with:
    <% for(char c = 'A'; c <= 'Z'; c++){
        String alphaLink = "runsearch.html?alpha=" + c;
    %>
      <a href="<%=alphaLink%>"><%=c%></a>

    <% } %>
    </h2>
  <table>
    <tr>
      <th>No.</th>
      <th>First Name</th>
      <th>Last Name</th>
    </tr>
      <%
        int number = 0;
        List<Patient> patients = (List<Patient>) request.getAttribute("patients");
        for (Patient patient : patients)
        {
          number ++;
          String href = "patientInfo.html?Id=" + patient.getID();
      %>
    <tr>
      <td><%=number%></td>
      <td><a href="<%=href%>"><%=patient.getFirst()%></a></td>
      <td><a href="<%=href%>"><%=patient.getLast()%></a></td>
    </tr>
    <%}%>
  </table>

</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>


