package Employee;

import User.NewUser;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ApplicationForm {
    Scanner sc = new Scanner(System.in);
    //Employee.ApplicationForm ap = new Employee.ApplicationForm();
    NewUser newuser;
    String Status = null;

    public void getDetails(Connection con) throws SQLException {

        System.out.println("...........Fill All Details Properly...........");

        System.out.print("* Enter Your First Name :-");
        String fname = sc.next();
        fname=fname.toLowerCase();

        System.out.print("* Enter Your Last Name :-");
        String lname = sc.next();
        lname=lname.toLowerCase();

        System.out.print("* Enter Your Email  :-");
        String email = sc.next();

        System.out.print("* Enter your mobile  Number :-");
        long mno = sc.nextLong();

        System.out.print("* Enter Your date of birth in format(DD/MM/YYYY)  :-");
        String DOB = sc.next();

        System.out.print("* Enter Your Gender :-");
        String gender = sc.next();
        gender=gender.toLowerCase();

        System.out.print("* Enter Your Education :-");
        String education = sc.next();
        education=education.toLowerCase();

        System.out.print("* Enter Your CGPA :-");
        float cgpa = sc.nextFloat();

        newuser   = new NewUser(fname,lname,education,mno,DOB,cgpa,email,gender);

        System.out.println("\n\n......... Check Details Properly .........");
        this.displayDetails();

        System.out.println("\n1. CORRECT DETAILS\t\t2. WRONG DETAILS");
        int ch = sc.nextInt();

        if(ch == 1){
            LocalDate today = LocalDate.now();
            LocalTime time = LocalTime.now();
            String insertQuery = "insert into tempUser (fname,lname,email,gender,DOB,education,mobileNo,managerId,status,ApplicationDate,ApplicationTime) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,newuser.getFname());
            ps.setString(2,newuser.getLname());
            ps.setString(3,newuser.getEmail());
            ps.setString(4,newuser.getGender());
            ps.setString(5,newuser.getDOB());
            ps.setString(6,newuser.getEducation());
            ps.setLong(7,newuser.getMobNo());
            ps.setInt(8,10001);
            ps.setString(9,"pending");
            ps.setDate(10, Date.valueOf(today));
            ps.setTime(11, Time.valueOf(time));
            int row = ps.executeUpdate();
            if(row>0){
                this.displayDetails();
                System.out.println("Application Under Processing :).......");
                this.Status = "PENDING";
            }
            else {
                System.out.println("Something Went Wrong !!........");
            }
        }
        else {
            this.getDetails(con);
        }
    }

    public void displayDetails(){

        System.out.println("Details Are .......");
        System.out.println("----------------------------------------------");
        System.out.println("First Name  = " + newuser.getFname());
        System.out.println("Last Name = "+newuser.getLname());
        System.out.println("Email = "+newuser.getEmail());
        System.out.println("Mobile Number = "+newuser.getMobNo());
        System.out.println("Gender = "+newuser.getGender());
        System.out.println("Date Of Birth = "+newuser.getDOB());
        System.out.println("Education Details = "+newuser.getEducation());
        System.out.println("----------------------------------------------");
    }

}