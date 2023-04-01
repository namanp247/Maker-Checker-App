<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibanking.app.model.dao.entities.CustomerMasterDTO"%>
<%@ page import="com.ibanking.app.model.dao.entities.CustomerSlaveDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.18/css/jquery.dataTables.css"/>
  <script type="text/javascript" src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.js"></script>

        <script>
            $(document).ready( function () {
                    $('#master').DataTable();
            } );
          $(document).ready( function () {
                $('#slave').DataTable();
            } );
        </script>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <br>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <title>This is a Form</title>
</head>
<body>
        <table id = "slave" class="table table-striped ">
           <thead class = "thead-dark">
             <tr>
               <th scope="col">#</th>
               <th scope="col">Customer Code</th>
               <th scope="col">Customer Name</th>
               <th scope="col">Address Line 1</th>
               <th scope="col">Address Line 2</th>
               <th scope="col">PinCode</th>
               <th scope="col">Email</th>
               <th scope="col">Contact</th>
               <th scope="col">Primary Contact Person</th>
               <th scope="col">Record Status</th>
               <th scope="col">Active/Inactive Flag</th>
               <th scope="col">Authorize</th>
               <th scope="col">Reject</th>

             </tr>
           </thead>
           <tbody id= "tbody" name = "tbody">
                    <c:set var= "i" value = "1"/>
                <c:forEach items = "${customerListFromSlave}" var = "slave">
                    <tr>

                        <td><c:out value="${i}"/> </td>
                        <c:set var= "i" value = "${i+1}"/>
                        <td><c:out value="${slave.customerCode}"/> </td>
                        <td><c:out value="${slave.customerName}"/> </td>
                        <td><c:out value="${slave.address1}"/> </td>
                        <td><c:out value="${slave.address2}"/> </td>
                        <td><c:out value="${slave.pinCode}"/> </td>
                        <td><c:out value="${slave.email}"/> </td>
                        <td><c:out value="${slave.contactNumber}"/> </td>
                        <td><c:out value="${slave.primaryContactPerson}"/> </td>
                        <td><c:out value="${slave.recordStatus}"/> </td>
                        <td><c:out value="${slave.activeInactive}"/> </td>

                        <td>
                            <button id = <c:out value="authorizeBtn+${slave.customerCode}"/> ><a href= "authorizeCustomer?recStatus=<c:out value="${slave.recordStatus}"/>&auId=<c:out value="${slave.id}"/>"> Authorize</a></button>
                        </td>
                        <td>
                            <button id = <c:out value="rejectBtn+${slave.customerCode}"/> ><a href= "rejectCustomer?recStatus=<c:out value="${slave.recordStatus}"/>&rejId=<c:out value="${slave.id}"/>"> Reject</a></button>
                        </td>
                    </tr>
                </c:forEach>

           </tbody>
         </table>

         <br>
         <h6 align = "center">
                 ${param.status}
                 </h6>
        <br>
        <h6>
            Logged in as manager/maker.
        </h6>
        <br>
        <c:url var="logout" value="/logout">
            </c:url>
            <form:form action="${logout}" method ="post">
            <div>
                <button input type="submit" value="logout">Logout</button>
            </div>
            </form:form>
</body>
</html>