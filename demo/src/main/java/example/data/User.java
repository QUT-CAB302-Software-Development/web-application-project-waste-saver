package example.data;

/**
 * Represents a user of the application.
 */
public class User {
    private String name;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private double [] coordinates;
    private UserPref preferences;
    private UserStats statistics;

    /**
     * Creates a new User.
     *
     * @param firstName     The first name of the user.
     * @param lastName      The last name of the user.
     * @param password      The password of the user.
     * @param email         The email of the user.
     * @param coordinates   The coordinates of the user.
     */
    public User(String firstName, String lastName, String password, String email, double [] coordinates) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.coordinates = coordinates;
        this.preferences = new UserPref();
        this.statistics = new UserStats();
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Gets the last name of the user.
     *
     * @return The last name of the user.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the email of the user.
     *
     * @return The email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's UserPref preferences object
     *
     * @return A UserPref object of the user's preferences
     */
    public UserPref getPreferences() {
        return this.preferences;
    }

    /**
     * Gets the user's UserStats statistics object
     *
     * @return A UserStats object of the user's statistics
     */
    public UserStats getStatistics() {
        return this.statistics;
    }

    /**
     * Sets the name of the user.
     *
     * @param newName The new name of the user.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Sets the name of the user.
     *
     * @param newName The new name of the user.
     */
    public void setFirstName(String newName) {
        this.firstName = newName;
    }

    /**
     * Sets the name of the user.
     *
     * @param newName The new name of the user.
     */
    public void setLastName(String newName) {
        this.lastName = newName;
    }

    /**
     * Sets the password of the user.
     *
     * @param newPassword The new password of the user.
     */
    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    /**
     * Sets the email of the user.
     *
     * @param newEmail The new email of the user.
     */
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }


    public boolean setPreferences(UserPref newPreferences) {
        this.preferences = newPreferences;
        return true;
    }

    public boolean setStatistics(UserStats newStatistics) {
        this.statistics = newStatistics;
        return true;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCords(double[] coordinates) {
        this.coordinates = coordinates;
    }

}
