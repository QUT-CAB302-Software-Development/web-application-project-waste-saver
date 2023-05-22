package example.data;

public class Review {

    private int rating;
    private String user;
    private String message;

    public Review(int rating, String user, String message){
        this.rating = rating;
        this.user = user;
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

    public String getUser() {
        return user;
    }

    public boolean setUser(String user) {
        this.user = user;

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
