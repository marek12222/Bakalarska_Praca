package bp.springbootcassandrabp.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
public class FilmsByAuthor {
    @PrimaryKey
    private UUID uid;
    private String name;

    private int price;
    private String releaseDate;
    private String genre;
    private int rating;

    private UUID autorId;
    private List<UUID> reviewIds;

    private String firstName;
    private String lastName;
    private int age;

    public FilmsByAuthor(UUID uid, String name, int price, String releaseDate, String genre, int rating, UUID autorId, List<UUID> reviewIds, String firstName, String lastName, int age) {
        this.uid = uid;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
        this.autorId = autorId;
        this.reviewIds = reviewIds;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

