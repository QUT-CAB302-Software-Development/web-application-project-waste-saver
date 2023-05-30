package example.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a users preferences within the web application
 */
public class UserPref {

    private String address;
    private boolean donationNotifications;
    private int donationRadius;  //in km
    private Set<String> donationFoodTypes;
    private boolean expiryNotifications;

    /**
     * Creates a new UserPref object with default preferences values
     */
    public UserPref(){
        this.address = null;
        this.donationNotifications = true;
        this.donationRadius = 5;
        this.donationFoodTypes = new HashSet<>();
        this.expiryNotifications = true;
    }

    /**
     * Gets the address of the user.
     *
     * @return The address of the user.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns a boolean value of whether the user has enabled donation notifications.
     *
     * @return Boolean of whether the user has enabled donation notifications.
     */
    public boolean isDonationNotifications() {
        return donationNotifications;
    }

    /**
     * Gets the desired donation range of the user in km.
     *
     * @return The desired donation range of the user in km.
     */
    public int getDonationRadius() {
        return donationRadius;
    }

    /**
     * Gets the set of food types the user wishes to receive notifications for.
     *
     * @return The set of food types.
     */
    public Set<String> getDonationFoodTypes() {
        return donationFoodTypes;
    }

    /**
     * Returns a boolean value of whether the user has enabled expiry notifications.
     *
     * @return Boolean of whether the user has enabled expiry notifications.
     */
    public boolean isExpiryNotifications() {
        return expiryNotifications;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The user's address.
     * @return True if the operation was successful.
     */
    public boolean setAddress(String address) {
        this.address = address;
        return true;
    }

    /**
     * Enables or disables the user's donation notifications.
     *
     * @param donationNotifications The user's notification preference.
     * @return  True if the operation was successful.
     */

    public boolean setDonationNotifications(boolean donationNotifications) {
        this.donationNotifications = donationNotifications;
        return true;
    }

    /**
     * Set's the user's acceptable radius for donation notifications.
     *
     * @param donationRadius The user's new donation radius.
     * @return  True if the operation was successful.
     */
    public boolean setDonationRange(int donationRadius) {
        this.donationRadius = donationRadius;
        return true;
    }

    /**
     * Set's the user's preferred donation food types to a given list.
     *
     * @param donationFoodTypes The user's new list of preferred donation food types.
     * @return  True if the operation was successful.
     */
    public boolean setDonationFoodTypes(Set<String> donationFoodTypes) {
        this.donationFoodTypes = donationFoodTypes;
        return true;
    }

    /**
     * Adds a given food type to the user's list of preferred donation food types
     *
     * @param foodType  The food type to add to the user's list of preferred donation food types
     * @return  True if the operation was successful
     */
    public boolean addDonationFoodType(String foodType) {
        return this.donationFoodTypes.add(foodType);
    }

    /**
     * Enables or disables the user's expiry notifications.
     *
     * @param expiryNotifications The user's notification preference.
     * @return  True if the operation was successful.
     */
    public boolean setExpiryNotifications(boolean expiryNotifications) {
        this.expiryNotifications = expiryNotifications;
        return true;
    }


}
