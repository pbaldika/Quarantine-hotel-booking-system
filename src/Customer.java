public abstract class Customer
{
    private final Name name;
    private Room room;
    private int telp;
    private String passport_num;
    private String checkin_date;
    public Customer(Name n, Room r, int t, String p, String c)
    {
        room = r;
        name = n;
        telp = t;
        passport_num = p;
        checkin_date = c;
    }
    public abstract void display();
    public Name getName(){return name;}
    public Room getRoom(){return room;}
    public int getTelp(){return telp;}
    public String getPass(){return passport_num;}
    public String getCheckin(){return checkin_date;}
}
