package alpha.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameOfHome;
    private String kindOfHome;
    private String kindOfRoom;
    private String address;
    private int numberOfBedRoom;
    private int numberOfBathRoom;
    private String description;
    private double price;


    public Home() {
    }

    public Home(String nameOfHome, String kindOfHome, String kindOfRoom, String address, int numberOfBedRoom, int numberOfBathRoom, String description, double price) {
        this.nameOfHome = nameOfHome;
        this.kindOfHome = kindOfHome;
        this.kindOfRoom = kindOfRoom;
        this.address = address;
        this.numberOfBedRoom = numberOfBedRoom;
        this.numberOfBathRoom = numberOfBathRoom;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfHome() {
        return nameOfHome;
    }

    public void setNameOfHome(String nameOfHome) {
        this.nameOfHome = nameOfHome;
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
        return numberOfBedRoom;
    }

    public void setNumberOfBedRoom(int numberOfBedRoom) {
        this.numberOfBedRoom = numberOfBedRoom;
    }

    public int getNumberOfBathRoom() {
        return numberOfBathRoom;
    }

    public void setNumberOfBathRoom(int numberOfBathRoom) {
        this.numberOfBathRoom = numberOfBathRoom;
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
