/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    // JDBC driver and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/PetCafeBooking";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "yourpassword";  // Replace with your actual MySQL root password

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String activity = request.getParameter("activity");
        String bookingDate = request.getParameter("booking_date");
        int numberOfPeople = Integer.parseInt(request.getParameter("people"));

        // For simplicity, we'll assume a logged-in user with ID 1 (later, you'll want to replace this with real user info)
        int userId = 1;

        // Map the activity to an activity_id (this assumes you have corresponding entries in the activities table)
        int activityId = 0;
        if ("cats".equals(activity)) {
            activityId = 1;
        } else if ("coffee".equals(activity)) {
            activityId = 2;
        } else if ("library".equals(activity)) {
            activityId = 3;
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);
            
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare the SQL statement
            String sql = "INSERT INTO bookings (user_id, activity_id, booking_time, number_of_people) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, activityId);
            stmt.setString(3, bookingDate);
            stmt.setInt(4, numberOfPeople);

            // Execute the insert
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean-up environment
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        // Redirect to a confirmation page (you need to create this page, e.g., confirmation.jsp)
        response.sendRedirect("confirmation.jsp");
    }
}
