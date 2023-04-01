<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        .error{
            color: red;
            font-size:12px
        }
    </style>
    <title>This is a Form</title>
</head>
<body>

<%--when the submit button is clicked the mapping on controller with name same as inside the action will be called--%>
    <form:form action = "addNew" method = "post" modelAttribute = "customerFormBean">
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="customerCode">Enter Customer Code</label>
          <form:input type="text" class="form-control" id="customerCode" name = "customerCode" path = "customerCode"  placeholder="customerCode"/>
          <form:errors path = "customerCode" cssClass = "error"/>
        </div>
        <div class="form-group col-md-6">
          <label for="customerName">Enter Customer Name</label>
          <form:input type="text" class="form-control" id="customerName" name = "customerName" path = "customerName" placeholder="customerName"/>
          <form:errors path = "customerName" cssClass = "error"/>
        </div>
      </div>

      <div class="form-group">
          <label for="address">Address Line 1</label>
          <form:input type="text" class="form-control" id="address1" name = "address1" path = "address1" placeholder="Apartment, studio, or floor"/>
          <form:errors path = "address1" cssClass = "error"/>
      </div>
      <div class="form-group">
           <label for="address2">Address Line 2</label>
           <form:input type="text" class="form-control" id="address2" name = "address2" path = "address2" placeholder="Street, Locality"/>
         <form:errors path = "address2" cssClass = "error"/>

      </div>
      <div class="form-group">
                 <label for="pinCode">PinCode</label>
                 <form:input type="text" class="form-control" id="pinCode" name = "pinCode" path = "pinCode" placeholder="PinCode"/>
                 <form:errors path = "pinCode" cssClass = "error"/>

      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" class="form-control" id="email" name = "email" path = "email" placeholder="Email"/>
        <form:errors path = "email" cssClass = "error"/>

      </div>
      <div class="form-group">
        <label for="contact">Contact number</label>
        <form:input type="text" class="form-control" id="contact" name = "contactNumber" path = "contactNumber" placeholder="Contact"/>
        <form:errors path = "contactNumber" cssClass = "error"/>

      </div>
      <div class="form-group">
        <label for="primaryContactPerson">Contact Person</label>
        <form:input type="text" class="form-control" id="primaryContactPerson" name = "primaryContactPerson" path = "primaryContactPerson" placeholder="primaryContactPerson"/>
        <form:errors path = "primaryContactPerson" cssClass = "error"/>


      <div class="form-row">
        <div class="form-group col-md-4">
          <label for="activeInactive">Active Inactive Flag</label>
            <select id="state" class = "form-control" name = "activeInactive">
                    <option value="A">Active</option>
                    <option value="I">Inactive</option>
            </select>
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Add Customer</button>
    </form:form>
    <br>
        <c:url var="logout" value="/logout">
            </c:url>
            <form:form action="${logout}" method ="post">
            <div>
                <button form:input type="submit" value="logout">Logout</button>
            </div>
            </form:form>

</body>
</html>