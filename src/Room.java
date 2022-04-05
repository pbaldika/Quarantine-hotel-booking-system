public class Room 
{
    private int room_num;
    private double room_price;
    private String room_type;
    private int beds;
    private boolean empty = true;
    public Room(){}
    public Room(int n, double p, String t, int b)
    {
        room_num = n;
        room_price = p;
        room_type = t;
        beds = b;
    }
    public int getRoomNum(){return room_num;}
    public double getRoomPrice(){return room_price;}
    public String getRoomType(){return room_type;}
    public int getBeds(){return beds;}
    public Boolean getStatus(){return empty;}
    public void setFull(){empty = false;}
    public void setEmpty(){empty = true;}
}
