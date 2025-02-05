package Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class managerLogin {
    Scanner sc = new Scanner(System.in);

    public boolean managerLogin(Connection con) throws SQLException {
        boolean result=false;
        System.out.println("Enter Manager Id ");
        int id = sc.nextInt();
        System.out.println("Enter Manager password ");
        String pass = sc.next();

        String que = "select managerId,password from Manager where managerId =? AND password =?";
        PreparedStatement ps = con.prepareStatement(que);
        ps.setInt(1,id);
        ps.setString(2,pass);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            System.out.println("Login Successful...........");
            result = true;

            boolean running = true;
            while (running) {
                System.out.println("1 : Check Pending Application's : ");
                System.out.println("2 : Check Applied Leave by Employee : ");
                System.out.println("3 : My Employee : ");
                System.out.println("4 : Exit");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                            manager mn = new manager(con);
                            mn.getManagerDetails(id, pass);
                            mn.checkPendingApplictions();
                            mn.approveApplication();
                            break;
                    }
                    case 3 : {
                        String query = "select fname, lname, email, gender, DOB from tempUser where managerId = ? ";
                        PreparedStatement sp = con.prepareStatement(query);
                        sp.setInt(1,id);

                        ResultSet sr = sp.executeQuery();

                        System.out.println("fname  |lname     |email                      |gender|DOB");
                        System.out.println("-------+----------+---------------------------+------+------");
                        while(sr.next()) {
                            System.out.println(sr.getString("fname") + " | " + sr.getString("lname") + "     |     " + sr.getString("email") + "   |  " + sr.getString("gender"));
                        }
                        System.out.println("-------+----------+---------------------------+------+------");

                    }
                    case 4: {
                        running = false;
                        System.out.println("Exiting. GoodBye!");
                        break;
                    }
//                    manager manager1 = new manager(con);
//                    manager1.getManagerDetails(id, pass);
//                    manager1.checkPendingApplictions();
//                    manager1.approveApplication();
                }
            }
        }
        else {
            System.out.println("Invalid MANAGER ID and PASSWORD !!......");
        }

        return result;
    }

}