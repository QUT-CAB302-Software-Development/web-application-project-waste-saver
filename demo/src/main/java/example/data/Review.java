package example.data;

import example.application.exception.RecordNotFoundException;
import example.application.model.ReviewEntity;
import example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class Review {

    private int rating;
    private int authorID;
    private int to_userID;
    private String authorUsername;
    private String message;

    public List<Review> convertToUsable(List<ReviewEntity> entities){
        List<Review> usableReviews = new LinkedList<>();

        for(ReviewEntity e : entities){
            usableReviews.add(new Review(e.getRating(), e.getAuthorID(), e.getTo_userID(), e.getMessage()));
        }

        return usableReviews;
    }

    public Review(int rating, int authorID, int to_userID, String message){
        this.rating = rating;
        this.authorID = authorID;
        this.to_userID = to_userID;
        this.message = message;
    }

    public int getRating(){
        return rating;
    }

    public boolean setRating(int rate){

        if(rate <= 5 & rate >= 1){
            rating = rate;

            return true;
        }
        else {
            return false;
        }
    }

    public int getAuthorID() {
        return authorID;
    }


    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getAuthorUsername(){
        return authorUsername;
    }

    public boolean setUser(int authorID) {
        this.authorID = authorID;

        return true;
    }

    public String getMessage() {
        return message;
    }

    public boolean setMessage(String message) {
        this.message = message;

        return true;
    }

    public String getRatingString() {

        String ratingString = "";

        for (int i = 0; i<rating; i++){
            ratingString += "\u2B50";
        }

        return ratingString;
    }
}
