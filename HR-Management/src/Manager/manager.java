package Manager;

import java.sql.*;
import java.util.Scanner;

public class manager {
    Scanner sc = new Scanner(System.in);
    Connection con;
    int managerId;
    String password;
    String email;
    public void getManagerDetails(int id,String pass){
        this.managerId = id;
        this.password = pass;
    }

    public manager(Connection con){
        this.con = con;
    }

    public void checkPendingApplictions() throws SQLException {
        managerLogin login = new managerLogin();
        if (true){
            String query = "select * from tempUser where status = 'pending' and managerId=managerId";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("\n Application's");
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
                System.out.println("-------------------------------");
            }
        }
    }

    public void approveApplication() throws SQLException {
        System.out.println("Enter Email Id For Application Approve Or Reject ");
        String email = sc.next();

        System.out.println("1. Approve Application\t\t2. Reject Application");
        int ch = sc.nextInt();

        if(ch==1){
            System.out.println("Approve Application...........");
            String query = "select * from tempUser where status = 'pending' and managerId = ? and email = ?";
            PreparedStatement prepare = con.prepareStatement(query);
            //prepare.setString(1,"pending");
            prepare.setInt(1,this.managerId);
            System.out.println("\n Manager Id" + this.managerId);
            prepare.setString(2,email);
            System.out.println("\n Email Id" + email);
            Statement stmt = con.createStatement();
            ResultSet rs = prepare.executeQuery();

            while(rs.next()){
                System.out.println("\n Pending Application's");
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
                System.out.println("-------------------------------");
            }

            String update = "update tempUser set status = ? where email=?";
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1,"approved");
            ps.setString(2,email);
            int temp = ps.executeUpdate();

            System.out.println("Application Approved.........");

            String insert = "insert into Employee_Info(username, password, email, managerID) values(?,?,?,?)";
            try (PreparedStatement pst = con.prepareStatement(insert)) {
                pst.setString(1, email);
                String password = "password@12";
                pst.setString(2, password);

                pst.setString(3, email);
                System.out.println(managerId);
                pst.setInt(4, this.managerId);

                int rowsInserted = pst.executeUpdate();

                if (rowsInserted > 0) {
                    System.out.println("User created successfully!");
                    System.out.println("Username = " + email);
                    System.out.println("Password = " + password);
                } else {
                    System.out.println("Failed to create user.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Reject Application...........");
            System.out.println("Enter Reason ");
            Scanner sc1 = new Scanner(System.in);
            String quoet = sc1.nextLine();
            String query = "insert into Reasons (email,managerId,reason) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,email);
            ps.setInt(2,this.managerId);
            ps.setString(3,quoet);
            int row = ps.executeUpdate();
            if(row>0){
                System.out.println("Application Rejected Successfully.....");
                String update = "update tempUser set status = 'Rejected' where email=?";
                PreparedStatement pst = con.prepareStatement(update);
//                pst.setString(1,"Rejected");
                pst.setString(1,email);
                int temp = pst.executeUpdate();
                System.out.println("Hie");
            }
        }
    }
}