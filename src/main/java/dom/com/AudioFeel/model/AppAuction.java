package dom.com.AudioFeel.model;

import javax.persistence.*;


@Entity
public class AppAuction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auctionname;
    private String description;
    private int price;
    private String category;

    private String owner;
    private String highestBitter;
    private int endTime;

    @Lob
    private String image;

    public AppAuction(Long id, String auctionname, String description, int price, String category, String owner, String highestBitter, int endTime, String image) {
        this.id = id;
        this.auctionname = auctionname;
        this.description = description;
        this.price = price;
        this.category = category;
        this.owner = owner;
        this.highestBitter = highestBitter;
        this.endTime = endTime;
        this.image = image;
    }

    public AppAuction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuctionname() {
        return auctionname;
    }

    public void setAuctionname(String auctionname) {
        this.auctionname = auctionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getHighestBitter() {
        return highestBitter;
    }

    public void setHighestBitter(String highestBitter) {
        this.highestBitter = highestBitter;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
