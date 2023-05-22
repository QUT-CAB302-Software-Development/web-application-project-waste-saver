package example.application.model;

import example.application.exception.RecordNotFoundException;
import example.application.service.UserService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="REVIEWS")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authorID")
    private int authorID;
    @Column(name = "to_userID")
    private int to_userID;
    @Column(name = "rating")
    private int rating;
    @Column(name = "message")
    private String message;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getAuthorID() { return authorID; }
    public void setAuthorID(int authorID) { this.authorID = authorID; }
    public int getTo_userID() { return to_userID; }
    public void setTo_userID(int to_userID) { this.to_userID = to_userID; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString(){
        return "UserEntity [id=" + id + ", author=" + authorID +
                ", to_user=" + to_userID + ", rating=" + rating   +
                ", message=" + message + "]";
    }

}