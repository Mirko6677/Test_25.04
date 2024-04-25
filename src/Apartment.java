package bg.smg;

public class Apartment {
    String city;
    int rooms;
    int area;
    int price;
    String phone;

    public Apartment(String city, int rooms, int area, int price, String phone) {
        this.city = city;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
        this.phone = phone;
    }
}