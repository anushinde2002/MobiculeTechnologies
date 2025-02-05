//import Manager.manager.Manager.managerLogin;
//import UserAccess.Employee.ApplicationForm;
//import UserAccess.Employee.ApplicationForm;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.*;
//
//public class Connectivity {
//    public Connectivity(){
//        String url = "jdbc:mysql://Tejas@localhost:3306/GretHR";
//        String user = "Tejas";
//        String pass = "Tejas172304@";
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url,user,pass);
//            if (con == null) {
//                System.out.println("Connection Failed....");
//            }
//            else{
//                LocalDate today = LocalDate.now();
//                System.out.println("Todays Date is "+today);
//                System.out.println("Connection Created.........");
//                Employee.ApplicationForm AP = new Employee.ApplicationForm();
//                AP.getDetails(con);
//                ManagerLogin login = new ManagerLogin();
//                login.Manager.managerLogin(con);
//                //u.displayDitails();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//}