<%@ page import="model.payment" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.js"></script>
<script src="Components/items.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>Payment Management </h1>
<form id="formItem" name="formItem">
 Customer Name: 
 <input id="customerName" name="customerName" type="text" 
 class="form-control form-control-sm">
 <br>  email: 
 <input id="email" name="email" type="text" 
 class="form-control form-control-sm">
 <br>  contactNo: 
 <input id="contactNo" name="contactNo" type="text" 
 class="form-control form-control-sm">
 <br>  amount: 
 <input id="amount" name="amount" type="text" 
 class="form-control form-control-sm">
 <br>
 <br>  paymentDate: 
 <input id="paymentDate" name="paymentDate" type="text" 
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 payment paymentObj = new payment(); 
	 out.print(paymentObj.readPayment()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>
