import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MusicApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);

        //account create logic
        System.out.println("Welcome to MusicApp");
        System.out.println("Enter username:");
        String username=sc.nextLine();

        System.out.println("Enter Password:");
        String Password=sc.nextLine();

        User user=new User(username,Password);

        System.out.println("Account created successfully..!!");
        System.out.println("Welcome Anita");


        //login logic
        System.out.println("\n Login-Enter username:");
        String loginUsername=sc.nextLine();

        System.out.println("Enter Password:");
        String loginPassword=sc.nextLine();

        if(user.login(loginUsername, loginPassword))
        {
            System.out.println("Login successful..!");

            //create lib logic

            MusicLib lib=new MusicLib();
            lib.addSong(new Song("Dil to pagal hai","2:23","Lata Mangeshkar"));
            lib.addSong(new Song("Pappa meri jaan","5:11","Sonu Nigam"));
            lib.addSong(new Song("Satranga","4:2","Sonu Nigam"));
            lib.addSong(new Song("Har ek Friend Kamina hota hai","4:22","Sonu Nigam"));
            lib.addSong(new Song("Mitra Vanvyamdhe","3:88","Anand Shinde"));
            lib.addSong(new Song("AApli yarri","5:22","Anand Shinde"));
            lib.addSong(new Song("Never give up","3:22","Amir khan"));
            lib.addSong(new Song("Tu hi to","1:72","Neha Kakkar"));
            lib.addSong(new Song("null","1:00","Sunidhi chauhan"));


            //menu driven code to search and display song by singer name

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1.Search song by Singer:");
                System.out.println("2.Exit");
                System.out.println("Enter ur choice");
                choice=sc.nextInt();
                sc.nextLine();

                switch(choice) {
                    case 1:
                        System.out.println("Enter singer's name:");
                        String singer=sc.nextLine();
                        lib.displaySongBySinger(singer);

                        break;

                    case 2:
                        System.out.println("Exiting MusicApp....GoodBye!!");
                        break;
                    default:
                        System.out.println("Invalid Choice..Try again");


                }}while(choice!=2);
        }else {

            System.out.println("Login failed. Invalid credentials:");

        }
        sc.close();
    }
}