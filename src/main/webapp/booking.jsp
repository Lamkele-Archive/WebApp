<%-- 
    Document   : booking
    Created on : 26 Mar 2025, 16:40:53
    Author     : entle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Your Visit</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
    <h1>Welcome to the Cozy Cat Cafe & Library</h1>
    <form action="BookingServlet" method="POST">
        <label for="activity">Choose Activity:</label>
        <select name="activity" id="activity">
            <option value="cats">Pet the Cats</option>
            <option value="coffee">Enjoy Coffee</option>
            <option value="library">Read Books</option>
        </select>
        <br><br>
        <label for="booking_date">Choose Date & Time:</label>
        <input type="datetime-local" id="booking_date" name="booking_date" required>
        <br><br>
        <label for="people">Number of People:</label>
        <input type="number" id="people" name="people" min="1" required>
        <br><br>
        <button type="submit">Book Now</button>
    </form>
</body>
</html>

