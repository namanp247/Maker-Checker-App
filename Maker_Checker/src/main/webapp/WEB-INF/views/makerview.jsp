<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ibanking.app.model.dao.entities.CustomerMasterDTO"%>
<%@ page import="com.ibanking.app.model.dao.entities.CustomerSlaveDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <title>This is a Form</title>
</head>
<body>
              <h5 align = "center">
                               Master Table
                </h5>
                          <hr class="mt-2 mb-3"/>


   <table id = "master" class="table table-striped ">
           <thead class = "thead-light">
             <tr>
               <th scope="col">#</th>
               <%--import variable values from Resource bundle message--%>
               <th ><spring:message code="msg.customerCode" text = "Customer Code"/></th>
               <th ><spring:message code="msg.customerName" text = "Customer Name"/></th>
               <th ><spring:message code="msg.address1" text = "Address Line 1"/></th>
               <th ><spring:message code="msg.address2" text = "Address Line 2"/></th>
               <th ><spring:message code="msg.pincode" text = "PinCode"/></th>
               <th ><spring:message code="msg.email" text = "Email"/></th>
               <th ><spring:message code="msg.contactNumber" text = "Contact"/></th>
               <th ><spring:message code="msg.primaryContact" text = "Primary Contact Person"/></th>
               <th ><spring:message code="msg.recordStatus" text = "Record Status"/></th>
              <th ><spring:message code="msg.activeinactive" text = "Active/Inactive Flag"/></th>
               <th ><spring:message code="msg.update" text = "Update"/></th>
               <th ><spring:message code="msg.delete" text = "Delete"/></th>
             </tr>
           </thead>

           <tbody id= "tbody" name = "tbody">

           <%--c: is part of jstl and will not appear on front end, mainly used for programming purpose like defining variable and implementing loops and all--%>
           <c:set var= "i" value = "1"/>
           <%--${xyz}: el(expression language} used for transferring data withing the different scopes(Page Scope, Request, Session, Context) in increasing order--%>
            <c:forEach items = "${customerListFromMaster}" var = "master">
                    <tr>
                        <td><c:out value="${i}"/> </td>
                        <c:set var= "i" value = "${i+1}"/>
                        <%--For customerCode to be called for each customer, @Getter should be called on master file--%>
                        <td><c:out value="${master.customerCode}"/> </td>
                        <td><c:out value="${master.customerName}"/> </td>
                        <td><c:out value="${master.address1}"/> </td>
                        <td><c:out value="${master.address2}"/> </td>
                        <td><c:out value="${master.pinCode}"/> </td>
                        <td><c:out value="${master.email}"/> </td>
                        <td><c:out value="${master.contactNumber}"/> </td>
                        <td><c:out value="${master.primaryContactPerson}"/> </td>
                        <td><c:out value="${master.recordStatus}"/> </td>
                        <td><c:out value="${master.activeInactive}"/> </td>
                        <td>
                            <%--below href format is used for dynamic url routing--%>
                            <%--redirect to update_info page--%>
                            <button id = <c:out value="updateBtn+${master.customerCode}"/> ><a href= "updateMaster?recStatus=<c:out value="${master.recordStatus}"/>&upid=<c:out value="${master.customerCode}"/>"> Update</a></button>                        </td>
                        </td>
                        <td>
                            <button id = <c:out value="deleteBtn+${master.customerCode}"/> ><a href= "deleteMaster?recStatus=<c:out value="${master.recordStatus}"/>&delid=<c:out value="${master.customerCode}"/>"> Delete</a></button>
                        </td>
                    </tr>
                </c:forEach>
           </tbody>
         </table>

<%--redirect on the same page but with changed language as per user request--%>
<h5><a align = "left" href="maker?language=en">English</a> <tab><tab> <a href="maker?language=ch">Chinese</a> <a align = "right" href="maker?language=hi_IN">Hindi</a></h5>

          <hr class="mt-2 mb-3"/>
          <h5 align = "center">
                           Slave Table
            </h5>
                      <hr class="mt-2 mb-3"/>


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
               <th scope="col">Update</th>
               <th scope="col">Delete</th>

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
                            <button id = <c:out value="updateBtn+${slave.customerCode}"/> ><a href= "updateThis?recStatus=<c:out value="${slave.recordStatus}"/>&upid=<c:out value="${slave.id}"/>"> Update</a></button>
                        </td>
                        <td>
                            <button id = <c:out value="deleteBtn+${slave.customerCode}"/> ><a href= "deleteThis?recStatus=<c:out value="${slave.recordStatus}"/>&delid=<c:out value="${slave.id}"/>"> Delete</a></button>
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
        <button id = "buttonAddCustomer" name = "buttonAddCustomer"><a href="addCustomer"> Add new Customer</a></button>
        <br>

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