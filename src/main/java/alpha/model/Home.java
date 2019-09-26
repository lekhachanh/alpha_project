package alpha.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int bedroom;
    private int bathRoom;
    private String description;
    private double price;

    @OneToMany(targetEntity = Image.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<Image> images;


    public Home() {
    }

    public Home(String name, String address, int bedroom, int bathRoom, String description, double price, List<Image> images) {
        this.name = name;
        this.address = address;
        this.bedroom = bedroom;
        this.bathRoom = bathRoom;
        this.description = description;
        this.price = price;
        this.images = images;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
