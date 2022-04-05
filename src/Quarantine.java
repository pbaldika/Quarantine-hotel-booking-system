public class Quarantine extends Customer implements Prices
{

    private int q_package;
    public Quarantine(Name n, Room r, int t, String p, String c, int q)
    {
        super(n,r,t,p,c);
        q_package = q;
    }
    public void display()
    {
        System.out.println("full name: ............ " + super.getName().toString());
        System.out.println("phone number: ......... " + super.getTelp());
        System.out.println("passport number: ...... " + super.getPass());
        System.out.println("room number: .......... " + super.getRoom().getRoomNum());
        System.out.println("room type: ............ " + super.getRoom().getRoomType());
        System.out.println("check in date: ........ " + super.getCheckin());
        System.out.print("quarantine package: ... ");
        if(q_package == 1)
        {
            System.out.print("A\n");
            System.out.println("\t- 5 days\n\t- standard meals (2x per day)\n\t- PCR test A");
        }
        if(q_package == 2)
        {
            System.out.print("B\n");
            System.out.println("\t- 14 days\n\t- standard meals (2x per day)\n\t- PCR test A\n\t- airport to hotel transport");
        }
        if(q_package == 3)
        {
            System.out.print("C\n");
            System.out.println("\t- 14 days\n\t- premium meals (2x per day)\n\t- PCR test B\n\t- airport to hotel transport");
        }
    }
    public void calcPrice()
    {
        if(q_package == 1)
        {
            double food_total = standard_meals * 5;
            double room_total = super.getRoom().getRoomPrice() * 5;
            double test_total = PCRtestA;
            double grand_total = food_total + room_total + test_total;
            System.out.println("meals for 5 days: .... RM" + food_total);
            System.out.println("room for 5 day: ...... RM" + room_total);
            System.out.println("PCR test: ............ RM" + test_total);
            System.out.println("TOTAL ................ RM" + grand_total);
        }
        if(q_package == 2)
        {
            double food_total = standard_meals * 14;
            double room_total = super.getRoom().getRoomPrice() * 14;
            double test_total = PCRtestA;
            double grand_total = food_total + room_total + test_total + transport;
            System.out.println("meals for 14 days: ............ RM" + food_total);
            System.out.println("room for 14 day: .............. RM" + room_total);
            System.out.println("PCR test: ..................... RM" + test_total);
            System.out.println("airport to hotel transport: ... RM" + transport);
            System.out.println("TOTAL ......................... RM" + grand_total);
        }
        if(q_package == 3)
        {
            double food_total = premium_meals * 14;
            double room_total = super.getRoom().getRoomPrice() * 14;
            double test_total = PCRtestB;
            double grand_total = food_total + room_total + test_total + transport;
            System.out.println("meals for 14 days: ............ RM" + food_total);
            System.out.println("room for 14 day: .............. RM" + room_total);
            System.out.println("PCR test: ..................... RM" + test_total);
            System.out.println("airport to hotel transport: ... RM" + transport);
            System.out.println("TOTAL ......................... RM" + grand_total);
        }
    }
}
