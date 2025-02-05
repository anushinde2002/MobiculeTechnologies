package Employee;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class empLogin {
    public void employeeLogin(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("********Employee Login********");

        System.out.println("Enter Email");
        String username = sc.next();
        System.out.println("Enter Your Password ");
        String password = sc.next();

        String query = "select username, password, managerId from Employee_Info where username = ? AND password = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int managerId = rs.getInt("managerId"); // Use directly

            System.out.println("Login Successful...........");
            System.out.println();
//            ps.close();

            boolean running = true;
            boolean flag = false;
            while (running) {
                System.out.println("1 : Apply For Leave ");
                System.out.println("2 : Attendence Info ");
                System.out.println("3 : Mark Attendence ");
                System.out.println("4 : Manager ");
                System.out.println("5 : Change Password ");
                System.out.println("6 : Exit");

                int choice = sc.nextInt();
                switch (choice) {
                    case 2 : {
                            String querry = "select employee_id, sign_in, sigh_out from attendence_Info where employee_id = ?";
                        PreparedStatement psq = connection.prepareStatement(querry);
                        psq.setString(1, username);
                        ResultSet rsq = psq.executeQuery();
                        System.out.println("UserName          |sign_in |sigh_out|");
                        System.out.println("------------------+--------+--------+");
                        while (rsq.next()) {
                            System.out.println(username + "  " + rsq.getTime("sign_in") + "-+-" + (rsq.getTime("sigh_out")));
                        }
                        System.out.println("------------------+--------+--------+");
                    }
                    break;
                    case 3:
                        if (!flag) {
                            System.out.println("Enter one for sign In ");
                            sc.nextInt();
                            System.out.println("Sign In: " + LocalDateTime.now());
                            flag = true;

                            String query_at = "INSERT INTO attendence_Info (employee_id, sign_in, sigh_out) VALUES (?, ?, ?)";
                            PreparedStatement pst = connection.prepareStatement(query_at);
                            pst.setString(1, username);
                            pst.setTime(2, Time.valueOf(LocalTime.now()));
                            pst.setTime(3, null);
                            pst.executeUpdate();
                        } else {
                            String query_out = "UPDATE attendence_Info SET sigh_out = ? WHERE id = (SELECT id FROM (SELECT MAX(id) AS id FROM attendence_Info) AS max_id)";
                            PreparedStatement pst = connection.prepareStatement(query_out);
                            pst.setTime(1, Time.valueOf(LocalTime.now()));
                            pst.executeUpdate();
                            System.out.println("Enter one for Sign Out");
                            sc.nextInt();
                            System.out.println("Sign Out: " + LocalDateTime.now());
                            flag = false;
                        }
                        break;
                    case 4:
                        String query1 = "select managerName, email from Manager where managerId = ?";
                        PreparedStatement pst = connection.prepareStatement(query1);
                        pst.setInt(1, managerId);
                        ResultSet rst = pst.executeQuery();

                        if (rst.next()) {
                            String name = rst.getString("managerName");
                            System.out.println("Manager Name: " + name);
                            System.out.println("Email: " + rst.getString("email"));
                        } else {
                            System.out.println("No manager found with ID " + managerId);
                        }
                        break;

                    case 5 : {
                        ChanagePassword cp = new ChanagePassword();
                        cp.changePassword(connection);
                        break;
                    }
                    case 6:
                        running = false;
                        System.out.println("Exiting. GoodBye!");
                        break;
                }
            }

        } else {
            System.out.println("Invalid user ID and PASSWORD !!......");
        }
    }
}