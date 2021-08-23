package bp.springbootcassandrabp.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table
public class Film  {


    @PrimaryKey
    private UUID uid;
    private String name;

    private int price;
    private String releaseDate;
    private String genre;
    private int rating;

    private UUID autorId;
    private List<UUID> reviewIds;

    protected  Film(){
        this.reviewIds = new ArrayList<>();
    }

    public Film(UUID uid, String name, int price, String releaseDate, String genre,int rating, UUID autorId, List<UUID> reviewIds) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating=rating;
        this.autorId = autorId;
        this.reviewIds = reviewIds;
    }
    public Film(UUID uid, String name, int price, String releaseDate, String genre,int rating, UUID autorId) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating=rating;
        this.autorId = autorId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public UUID getAutorId() {
        return autorId;
    }

    public void setAutorId(UUID autorId) {
        this.autorId = autorId;
    }

    public List<UUID> getReviewIds() {
        return reviewIds;
    }

    public void setReviewIds(List<UUID> reviewIds) {
        this.reviewIds = reviewIds;
    }
}
