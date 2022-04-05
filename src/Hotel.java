import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

class invalidPackageException extends Exception
{
    public invalidPackageException(String s){super(s);}
}

public class Hotel 
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        Vector<Room> room_list = new Vector<Room>();
        Room r201 = new Room(201, 20.00, "regular", 1); 
        Room r202 = new Room(202, 20.00, "regular", 1); 
        Room r203 = new Room(203, 50.00, "premium", 2); 
        Room r204 = new Room(204, 50.00, "premium", 2); 
        Room r205 = new Room(205, 70.00, "deluxe ", 2); 
        Room r206 = new Room(206, 70.00, "deluxe ", 2); 

        room_list.add(r201);
        room_list.add(r202);        
        room_list.add(r203);        
        room_list.add(r204);        
        room_list.add(r205);        
        room_list.add(r206);        

        System.out.println("            [AVAIABLE ROOMS]            ");
        System.out.println("========================================");
        System.out.println("ROOM     PRICE/NIGHT     TYPE       BEDS");
        System.out.println("========================================");

        //FIND NUMBER OF AVAILABLE ROOMS
        int available = 0;
        for(int i=0; i<room_list.size(); i++)
        {
            if(room_list.get(i).getStatus() == true){available++;}
        }

        //PRINT AVAILABLE ROOMS
        for(int i=0; i<available; i++)
        {
            if(room_list.get(i).getStatus() == true)
            {
                System.out.println(
                room_list.get(i).getRoomNum() + "      " + room_list.get(i).getRoomPrice() + 
                "            " + room_list.get(i).getRoomType() + "     " + room_list.get(i).getBeds()
                );
            } 
        }

        //INITIALIZE ROOM OBJECT
        Room temp_room = new Room();
        try
        {
            System.out.print("select room number: ");
            int room_choice = input.nextInt();
            for(int i=0; i<room_list.size(); i++)
            {
                if(room_list.get(i).getRoomNum() == room_choice)
                {
                    room_list.get(i).setFull();
                    temp_room = room_list.get(i);
                }
            }    
        }
        catch(InputMismatchException e)
        {
            System.out.println("error: invalid room number"); 
            System.exit(0);
        }
        
        //INITIALIZE CUSTOMER FOR QUARANTINE OBJECT
        System.out.println("\n\nENTER YOUR IDENTITY INFORMATION");
        System.out.println("===============================");
        System.out.print("first name: ................. ");
        String fname = input.next();
        System.out.print("last name: .................. ");
        String lname = input.next();
        Name temp_name = new Name(fname, lname);
        System.out.print("phone number: ............... ");
        int tel = input.nextInt();
        System.out.print("passport number: ............ ");
        String pass = input.next();
        System.out.print("check in date (dd/mm/yy): ... ");
        String checkin = input.next();
        
        //USER SELECTS QUARANTINE PACKAGE
        int package_choice = 0;;
        try
        {
            System.out.println("\n\nSELECT QUARANTINE PACKAGE");
            System.out.println("=========================");
            System.out.println("[1] PACKAGE A : RM40/day : 5 days\n- standard meals (2x per day)\n- PCR test A\n");
            System.out.println("[2] PACKAGE B : RM50/day : 14 days\n- standard meals (2x per day)\n- PCR test A\n- airport to hotel transport\n");
            System.out.println("[3] PACKAGE C : RM85/day : 14 days\n- premium meals (2x per day)\n- PCR test B\n- airport to hotel transport\n");
            System.out.print("select package (1/2/3): ");
            package_choice = input.nextInt();
            if(package_choice > 3 || package_choice < 1){throw new invalidPackageException("error: invalid package");}
        }
        catch(invalidPackageException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
       
        Quarantine q1 = new Quarantine(temp_name, temp_room, tel, pass, checkin, package_choice);

        //DISPLAY QUARANTINE BOOKING
        System.out.println("\n\nBOOKING OVERVIEW");
        System.out.println("================");
        q1.display();
        System.out.println("\n\nCOST OVERVIEW");
        System.out.println("=============");
        q1.calcPrice();

        System.out.println("\nTHANK YOU FOR BOOKING, ENJOY YOUR STAY\n");
    }    
}
