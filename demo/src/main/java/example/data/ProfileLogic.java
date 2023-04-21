package example.data;


public class ProfileLogic {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    public void processPersonalDetails(User user, String fname, String lname, String password) {

        if (fname != null && !fname.isEmpty()){
            user.setFirstName(fname);
        }

        if (lname != null && !lname.isEmpty()){
            user.setLastName(lname);
        }

        if (password != null && !password.isEmpty()){
            user.setPassword(password);
        }

        userDAO.updateUser(user);

    }


    public void deleteUserAccount(User user) {
        userDAO.deleteUser(user.getEmail());
    }

    public void processPreferences(User user, boolean donoAlert, int radius, boolean expAlert) {
        UserPref prefs = user.getPreferences();

        prefs.setDonationNotifications(donoAlert);
        prefs.setDonationRange(radius);
        prefs.setExpiryNotifications(expAlert);

        userDAO.updateUser(user);
    }

    public void resetPreferences(User user) {
        user.setPreferences(new UserPref());

        userDAO.updateUser(user);
    }
}
