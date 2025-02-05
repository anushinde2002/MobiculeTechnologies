//package Employee;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class MarkAttendence {
//    static class SwapRecord {
//        String action;
//        LocalDateTime timestamp;
//
//
//        //constructors
//        SwapRecord(String action, LocalDateTime timestamp) {
//            this.action = action;
//            this.timestamp = timestamp;
//        }
//    }
//    public static void markAttendence()
//    {
//        ArrayList<SwapRecord> rec=new ArrayList<>();
//        Scanner sc=new Scanner(System.in);
//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-mm-dd HH:MM:SS");
//        boolean running=true;
//
//        boolean flag=false;
//
//        System.out.println("Emp Attendence details:");
//        System.out.println("1.Mark Attendence :");
//        System.out.println("3.Maintain Record of Swap in and swap out");
//        System.out.println("4.Exit");
//
//        while(running)
//        {
//            System.out.println("Enter Emp Id ");
//            sc.nextInt();
//            System.out.println("\n Plz Choose an Option(1-4):");
//
//            int choice=sc.nextInt();
//            switch(choice){
//                case 1:
//                    if(flag==false)
//                    {
//
//                        System.out.println("1.sign In");
//                        sc.nextLine();
//                        rec.add(new SwapRecord("Swap In",LocalDateTime.now()));
//
//                        System.out.println("Swap in at:"+LocalDateTime.now().format(formatter));
//                        flag = true;
//                    }
//                    else{
//                        System.out.println("2.sign out");
//                        rec.add(new SwapRecord("Swap Out",LocalDateTime.now()));
//                        System.out.println("Swap  Out at:"+LocalDateTime.now().format(formatter));
//                        flag=false;
//                    }
//
//
//                    break;
//
////                case 2:
////                    rec.add(new SwapRecord("Swap Out",LocalDateTime.now()));
////                    System.out.println("Swap  Out at:"+LocalDateTime.now().format(formatter));
////                    break;
//
//                case 3:
//                    System.out.println("\n Emp Attendence records:");
//                    for(SwapRecord record:rec){
//                        System.out.println(record.action+" at "+record.timestamp.format(formatter));
//                    }
//                    break;
//                case 4:
//                    running =false;
//                    System.out.println("Exiting . GoodBye!");
//                    break;
//
//                default:
//                    System.out.println("Invalid option! Plz....try again.");
//
//
//            }
//        }
//        sc.close();
//
//    }
//}
