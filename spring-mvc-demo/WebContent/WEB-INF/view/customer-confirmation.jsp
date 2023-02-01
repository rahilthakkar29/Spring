<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Confirmed</title>
</head>

<body>

	<h2>Customer Confirmed....</h2>
	
	Name of the customer: ${customer.firstName} ${customer.lastName}
	
	<br><br>
	
	Free passes: ${customer.freePasses}
	
	<br><br>
	
	Postal code: ${customer.postalCode}
	
	<br><br>
	
	Course code: ${customer.courseCode}
</body>
</html>