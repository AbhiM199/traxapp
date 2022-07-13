<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing information</title>
</head>
<body>
        <h2>Billing Info</h2>
      First Name : ${billing.firstName}<br/>
      Last Name : ${billing.lastName}<br/>
      Product Name : ${billing.productName} <br/>
      Email : ${billing.email}<br/>
      Mobile : ${billing.mobile}<br/>
      Amount : ${billing.amount}<br/>
</body>
</html>