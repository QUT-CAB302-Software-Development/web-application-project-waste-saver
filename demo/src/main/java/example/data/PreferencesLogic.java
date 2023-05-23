package example.data;


import example.application.exception.RecordNotFoundException;
import example.application.model.UserEntity;
import example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class PreferencesLogic {

    @Autowired
    UserService service;

    public void processPersonalDetails(UserEntity user, String fname, String lname) {

        if (fname != null && !fname.isEmpty()){
            user.setFirstName(fname);
        }

        if (lname != null && !lname.isEmpty()) {
            user.setLastName(lname);
        }

        service.createOrUpdateUser(user);

    }


    public void deleteUserAccount(UserEntity user) throws RecordNotFoundException {
        service.deleteUserId(user.getId());
    }



//    public void processPreferences(UserEntity user, UserPref newPrefs) {
//        UserPref prefs = user.getPreferences();
//
//        prefs.setDonationNotifications(newPrefs.isDonationNotifications());
//        prefs.setDonationRange(newPrefs.getDonationRadius());
//        prefs.setExpiryNotifications(newPrefs.isExpiryNotifications());
//
//        userDAO.updateUser(user);
//    }


//    public void resetPreferences(UserEntity user) {
//        user.setPreferences(new UserPref());
//
//        service.createOrUpdateUser(user);
//    }
}
