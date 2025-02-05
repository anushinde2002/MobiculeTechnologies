import Employee.ApplicationForm;
//import Employee.MarkAttendence;
import Employee.empLogin;
import Manager.managerLogin;
import User.CheckApplicationStatus;

import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/HrManagerSystem";
        String username = "vishal";
        String password = "Vishal1234@";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            while (true) {
                System.out.println("1 : Employee Login ");
                System.out.println("2 : Manager Login ");
                System.out.println("3 : Sign_up New User  ");
//                System.out.println("4 : Mark_Attendence ");

                Scanner sc = new Scanner(System.in);

                ApplicationForm af = new ApplicationForm();

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 : {
                            empLogin el = new empLogin();
                            el.employeeLogin(connection);
                            break;
                    }
                    case 2 : {
                        managerLogin ml = new managerLogin();
                        ml.managerLogin(connection);
                        break;
                    }

                    case 3: {
                        System.out.println("1 : Feel_application_form ");
                        System.out.println("2 : Check_application_Status ");
                        int n = sc.nextInt();

                        switch (n) {
                            case 1: {
                                af.getDetails(connection);
                                break;
                            }
                            case 2: {
//                                String query = "select status from Employee where id = ?";
//                                PreparedStatement ps = connection.prepareStatement(query);
//                                System.out.println("Enter Employee ID");
//                                int id = sc.nextInt();
//                                ps.setInt(1, id);
//                                ResultSet resultSet = ps.executeQuery();
//                                if (resultSet.next()) {
//                                    String status = resultSet.getString("status");
//                                    System.out.println("Employee Status: " + status);
//                                } else {
//                                    System.out.println("Employee with ID not found.");
//                                }
                                CheckApplicationStatus status = new CheckApplicationStatus();
                                status.checkApplicationStatus(connection);
                                break;

                            }
                        }
                        break;
                    }

                    case 4 : {


                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Connection failed" + e.getMessage());
        }
    }
}