<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit team page</title>
</head>
<body>
<h1>Edit team page</h1>
<p>Here you can edit the existing Invoice.</p>
<p>${message}</p>
<form:form method="POST" commandName="invoice" action="${pageContext.request.contextPath}/invoice/edit/${invoice.ID}.html">
<table>
<tbody>
	<tr>
		<td>DespatchID:</td>
		<td><form:input path="despatchID" /></td>
	</tr>
	<tr>
		<td>DeliveredQuantity:</td>
		<td><form:input path="deliveredQuantity" /></td>
	</tr>
	<tr>
        <td>OrderLineReferanceID:</td>
        <td><form:input path="orderLineReferanceID" /></td>
    </tr>
    <tr>
        <td>ItemName:</td>
        <td><form:input path="itemName" /></td>
    </tr>
    <tr>
        <td>SellersIdentificaitonID:</td>
        <td><form:input path="sellersIdentificaitonID" /></td>
    </tr>
    <tr>
        <td>InvoiceQuantity:</td>
        <td><form:input path="invoiceQuantity" /></td>
    </tr>
    <tr>
        <td>ExtensionAmount:</td>
        <td><form:input path="extensionAmount" /></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><form:input path="price" /></td>
    </tr>

	<tr>
		<td><input type="submit" value="Edit" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>