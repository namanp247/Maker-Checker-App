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

    <title>This is a Form</title>
</head>
<body>

    <form:form action = "update" method = "post" modelAttribute = "customerFormBean">
       <input type="hidden" name="id" value="${customerFormBean.id}">
       <input type="hidden" name="masterSlave" value="${masterSlave}">
       <input type="hidden" name="recStatus" value="${recStatus}">
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="customerCode">Enter Customer Code</label>
          <input type="text" class="form-control" id="customerCode" name = "customerCode" placeholder="customerCode" value = "${customerFormBean.customerCode}" readonly>
        </div>
        <div class="form-group col-md-6">
          <label for="customerName">Enter Customer Name</label>
          <input type="text" class="form-control" id="customerName" name = "customerName" placeholder="customerName" value = "${customerFormBean.customerName}" readonly>
        </div>
      </div>
      <div class="form-group">
          <label for="address">Address Line 1</label>
          <input type="text" class="form-control" id="address1" name = "address1" placeholder="Apartment, studio, or floor" value = "${customerFormBean.address1}">
      </div>
      <div class="form-group">
           <label for="address2">Address Line 2</label>
           <input type="text" class="form-control" id="address2" name = "address2" placeholder="Street, Locality" value = "${customerFormBean.address2}">
      </div>
      <div class="form-group">
                 <label for="pinCode">PinCode</label>
                 <input type="text" class="form-control" id="address2" name = "pinCode" placeholder="PinCode" value = "${customerFormBean.pinCode}">
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" name = "email" placeholder="Email" value = "${customerFormBean.email}">
      </div>
      <div class="form-group">
        <label for="contact">Contact number</label>
        <input type="text" class="form-control" id="contact" name = "contactNumber" placeholder="Contact" value = "${customerFormBean.contactNumber}">
      </div>
      <div class="form-group">
        <label for="primaryContactPerson">Contact Person</label>
        <input type="text" class="form-control" id="primaryContactPerson" name = "primaryContactPerson" placeholder="primaryContactPerson" value = "${customerFormBean.primaryContactPerson}">


      <div class="form-row">
        <div class="form-group col-md-4">
          <label for="activeInactive">Active Inactive Flag</label>
            <select id="state" class = "form-control" name = "activeInactive">
                    <option value="A">Active</option>
                    <option value="I">Inactive</option>
            </select>
        </div>
      </div>

      <button type="submit" class="btn btn-primary">Update Customer</button>
    </form:form>
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