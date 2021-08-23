package bp.springbootcassandrabp.model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Review {

    @PrimaryKey
    private UUID uid;
    private String userName;
    private Integer rating;
    private String revText;

    protected Review() {}

    public Review(UUID uid,String userName, Integer rating, String revText) {
        this.uid=uid;
        this.userName = userName;
        this.rating = rating;
        this.revText = revText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRevText() {
        return revText;
    }

    public void setRevText(String revText) {
        this.revText = revText;
    }
}
