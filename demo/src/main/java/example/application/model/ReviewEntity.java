package example.application.model;

import jakarta.persistence.*;

@Entity
@Table(name="REVIEWS")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;
    @Column(name = "to_user")
    private String to_user;
    @Column(name = "rating")
    private int rating;
    @Column(name = "message")
    private String message;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getTo_user() { return to_user; }
    public void setTo_user(String to_user) { this.to_user = to_user; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public String toString(){
        return "UserEntity [id=" + id + ", author=" + author +
                ", to_user=" + to_user + ", rating=" + rating   +
                ", message=" + message + "]";
    }
}