package example.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import static java.lang.Math.round;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Represents a users statistics within the web application
 */
public class UserStats {

    private int saverPoints;
    private LocalDate joinDate;
    private List<Donation> donations;
    private List<Review> reviews;


    /**
     * Creates a new UserStats object with default statistics
     */
    public UserStats(){
        this.saverPoints = 0;
        this.joinDate = LocalDate.now();
        this.donations = new LinkedList<>();
        this.reviews = new LinkedList<>();
    }

    public UserStats(int points){
        this.saverPoints = points;
        this.joinDate = LocalDate.now();
        this.donations = new LinkedList<>();
        this.reviews = new LinkedList<>();
    }

    /**
     * Gets the points of the user.
     *
     * @return The points of the user.
     */
    public int getPoints() {
        return saverPoints;
    }

    public String getPointsString(){
        return Integer.toString(saverPoints);
    }

    /**
     * Gets the join date of the user.
     *
     * @return The join date of the user.
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getJoinString() {

        String str = joinDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));

        return str;

    }

    public String getDaysSinceJoin() {
        Long daysSince = DAYS.between(joinDate, LocalDate.now());

        return Long.toString(daysSince);
    }

    /**
     * Gets the donations of the user.
     *
     * @return The donations of the user.
     */
    public List<Donation> getDonations() {
        return donations;
    }

    /**
     * Gets the total amount of donations of the user.
     *
     * @return The total amount of donations of the user.
     */
    public int getDonationsTotal() {
        return donations.size();
    }

    public List<Review> getReviews() { return reviews; }

    /**
     * Sets the user's points.
     *
     * @param points The user's new points.
     * @return  True if the operation was successful.
     */

    public boolean setPoints(int points) {
        this.saverPoints = points;
        return true;
    }

    /**
     * Increments the user's points.
     *
     * @param points The user's points increment
     * @return  True if the operation was successful.
     */

    public boolean incrementPoints(int points) {
        this.saverPoints += points;

        return true;
    }

    /**
     * Set's the user's join date.
     *
     * @param date The user's new join date.
     * @return  True if the operation was successful.
     */
    public boolean setJoinDate(LocalDate date) {
        this.joinDate = date;
        return true;
    }

    /**
     * Set's the user's donations list.
     *
     * @param donations The user's new donations lists.
     * @return  True if the operation was successful.
     */
    public boolean setDonations(List<Donation> donations) {
        this.donations = donations;
        return true;
    }

    /**
     * Set's the user's reviews list.
     *
     * @param reviews The user's new reviews list.
     * @return  True if the operation was successful.
     */
    public boolean setReviews(List<Review> reviews) {
        this.reviews = reviews;
        return true;
    }

    public String averageReviews(){
        int sum = 0;
        int count = 0;
        for (Review r : reviews){
            sum += r.getRating();
            count++;
        }

        String str = "";

        if(count > 0){
            int avg = Math.round( sum / count );


            for (int i = 0; i<avg; i++){
                str += "\u2B50";
            }
        }


        return str;

    }

    /**
     * Adds a donation to the user's donations list.
     *
     * @param donation The donation to add.
     * @return  True if the operation was successful.
     */
    public boolean addDonation(Donation donation) {
        this.donations.add(donation);
        return true;
    }

    /**
     * Adds a review to the user's reviews list.
     *
     * @param review The review to add.
     * @return  True if the operation was successful.
     */
    public boolean addReview(Review review) {
        this.reviews.add(review);
        return true;
    }

    public String achievedTitle(){
        String title = "Untitled";
        for (Ranks rank : Ranks.values()){
            if (rank.achieved(saverPoints)){
                title = rank.getRankTitle();
            }
            else {
                break;
            }
        }

        return title;
    }

    public String pointsTillNextRank(){
        String str = "All Ranks Achieved";
        for (Ranks rank : Ranks.values()){
            if (!rank.achieved(saverPoints)){
                str = Integer.toString(rank.getPointsScore() - saverPoints);
                break;
            }
        }

        return str;
    }


}
