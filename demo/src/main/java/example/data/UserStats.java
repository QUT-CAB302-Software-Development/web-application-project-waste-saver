package example.data;

import java.util.*;

/**
 * Represents a users preferences within the web application
 */
public class UserStats {

    private int saverPoints;
    private Date joinDate;
     private List<Donation> donations;


    /**
     * Creates a new UserPref object with default preferences values
     */
    public UserStats(){
        this.saverPoints = 0;
        this.joinDate = new Date();
        this.donations = new LinkedList<>();
    }

    /**
     * Gets the points of the user.
     *
     * @return The points of the user.
     */
    public int getPoints() {
        return saverPoints;
    }

    /**
     * Gets the join date of the user.
     *
     * @return The join date of the user.
     */
    public Date getJoinDate() {
        return joinDate;
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
    public boolean setJoinDate(Date date) {
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
     * Adds a donation to the user's donations list.
     *
     * @param donation The donation to add.
     * @return  True if the operation was successful.
     */
    public boolean addDonation(Donation donation) {
        this.donations.add(donation);
        return true;
    }



}
