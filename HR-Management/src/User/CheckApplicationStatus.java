package User;

import java.sql.*;
import java.util.Scanner;

public class CheckApplicationStatus {
    Scanner sc = new Scanner(System.in);

    public void checkApplicationStatus(Connection con) throws SQLException {
        String reason1 = null;
        System.out.println("Enter Your Email ID ");
        String email = sc.next();
        System.out.println("enter Your Mobile Number ");
        String mobile = sc.next();
        String query = "select * from tempUser where email = ? and mobileNo = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,email);
        ps.setString(2,mobile);
        ResultSet rs = ps.executeQuery();

        String query1= "select reason from Reasons where email = ? ";
        PreparedStatement pst = con.prepareStatement(query1);
        pst.setString(1,email);
        ResultSet rs1 = pst.executeQuery();
        while (rs1.next()){
            reason1 = rs1.getString("reason");
        }

        if(reason1 == null){
            while(rs.next()){
                System.out.println("\n Application Details ");
                System.out.println("-------------------------------");
                System.out.println("First Name = "+rs.getString("fname"));
                System.out.println("Last Name = "+rs.getString("lname"));
                System.out.println("Gender = "+rs.getString("gender"));
                System.out.println("Date of Birth = "+rs.getString("DOB"));
                System.out.println("Education Details = "+rs.getString("education"));
                System.out.println("Email id = "+rs.getString("email"));
                System.out.println("Mobile Number = "+rs.getLong("mobileNo"));
                System.out.println("Application Date = "+rs.getDate("ApplicationDate"));
                System.out.println("Application Time = "+rs.getTime("ApplicationTime"));
                System.out.println("Application Status = "+rs.getString("status"));
                System.out.println("-------------------------------");
            }
        }
        else {
            while(rs.next()){
                System.out.println("\n Application Details ");
                System.out.println("-------------------------------");
                System.out.println("First Name = "+rs.getString("fname"));
                System.out.println("Last Name = "+rs.getString("lname"));
                System.out.println("Gender = "+rs.getString("gender"));
                System.out.println("Date of Birth = "+rs.getString("DOB"));
                System.out.println("Education Details = "+rs.getString("education"));
                System.out.println("Email id = "+rs.getString("email"));
                System.out.println("Mobile Number = "+rs.getLong("mobileNo"));
                System.out.println("Application Date = "+rs.getDate("ApplicationDate"));
                System.out.println("Application Time = "+rs.getTime("ApplicationTime"));
                System.out.println("Application Status = "+rs.getString("status"));
                System.out.println("Reason For Application Reject = "+reason1);
                System.out.println("-------------------------------");
            }
        }


    }
}