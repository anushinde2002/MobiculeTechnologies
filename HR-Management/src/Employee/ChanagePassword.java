package Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChanagePassword {
    String email = null;
    String password = null;
    Scanner sc = new Scanner(System.in);
    public void changePassword(Connection con) throws SQLException {
        System.out.println("Enter Your Email ID ");
        String id = sc.next();
        System.out.println("Enter Your Old Password ");
        String pass = sc.next();
        String query = "SELECT username,password from Employee_Info nu where username = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,id);
        ps.setString(2,pass);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            email = rs.getString("username");
            password = rs.getString("password");
        }
        if (email==null && password==null){
            System.out.println("Invalid Username and Password Details.........:( ");
        }
        else {
            System.out.println("Enter Your New Password ");
            String temp = sc.next();
            System.out.println("Re-Enter Your New Password ");
            String temp1 = sc.next();
            if(temp.equals(temp1)){
                String update="UPDATE Employee_Info set password = ? where email = ?;";
                PreparedStatement pst = con.prepareStatement(update);
                pst.setString(1,temp1);
                pst.setString(2,email);
                int x = pst.executeUpdate();
                if (x>0){
                    System.out.println("Password Change Successfully.......:)");
                }
                else {
                    System.out.println("Something Went Wrong......");
                }
            }
            else {
                System.out.println("Enter Password Correctly............");
            }
        }
    }
}