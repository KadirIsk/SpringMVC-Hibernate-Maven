<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of teams</title>
</head>
<body>
<h1>List of Invoices</h1>
<p>Here you can see the list of the invoices, edit them, remove or update.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="15%">ID</th>
<th width="8%">DespatchID</th>
<th width="10%">DeliveredQuantity</th>
<th width="13%">OrderLineReferanceID</th>
<th width="13%">ItemName</th>
<th width="15%">SellersIdentificaitonID</th>
<th width="10%">InvoiceQuantity</th>
<th width="10%">ExtensionAmount</th>
<th width="5%">Price</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="invoice" items="${invoices}">
<tr>
	<td>${invoice.ID}</td>
	<td>${invoice.despatchID}</td>
	<td>${invoice.deliveredQuantity}</td>
	<td>${invoice.orderLineReferanceID}</td>
    <td>${invoice.itemName}</td>
    <td>${invoice.sellersIdentificaitonID}</td>
    <td>${invoice.invoiceQuantity}</td>
    <td>${invoice.extensionAmount}</td>
    <td>${invoice.price}</td>

	<td>
	<a href="${pageContext.request.contextPath}/invoice/edit/${invoice.ID}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/invoice/delete/${invoice.ID}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>