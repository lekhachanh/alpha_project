package alpha.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String kindOfHome;
    private String kindOfRoom;
    private String address;
    private int bedroom;
    private int bathRoom;
    private String description;
    private double price;


    public Home() {
    }

    public Home(String name, String kindOfHome, String kindOfRoom, String address, int bedroom, int bathRoom, String description, double price) {
        this.name = name;
        this.kindOfHome = kindOfHome;
        this.kindOfRoom = kindOfRoom;
        this.address = address;
        this.bedroom = bedroom;
        this.bathRoom = bathRoom;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindOfHome() {
        return kindOfHome;
    }

    public void setKindOfHome(String kindOfHome) {
        this.kindOfHome = kindOfHome;
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public void setKindOfRoom(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBedRoom() {
        return bedroom;
    }

    public void setNumberOfBedRoom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(int bathRoom) {
        this.bathRoom = bathRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
