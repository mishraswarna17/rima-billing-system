<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Billing System</title>
</head>
<body>

<h2>Welcome to Billing System</h2>

<form action="<%=request.getContextPath()%>/createBill" method="post">

    Customer Name: <input type="text" name="customer"><br>
    Product Name: <input type="text" name="product"><br>
    Price: <input type="text" name="price"><br>
    Qty: <input type="text" name="qty"><br>

    <input type="submit" value="Create Bill">
</form>

</body>
</html>
