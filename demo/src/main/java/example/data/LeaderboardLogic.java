package example.data;

import example.application.model.UserEntity;
import example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderboardLogic {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    @Autowired
    UserService service;

    private boolean used = false;

    public LeaderboardLogic(){

    }
    public void loadDummyDatabase(){

        if(used){
            return;
        }

        User u1 = new User("Jayden", "Hobbs", "123", "jayden@gmail", new double []{-27.4785, 153.0284});
        UserStats s1 = new UserStats(124);
        u1.setStatistics(s1);

        User u2 = new User("Bob", "Dylan", "123", "bob@dylan.com", new double []{-27.4785, 153.0284});
        UserStats s2 = new UserStats(938);
        s2.setJoinDate(LocalDate.of(2020, 3, 7));
        u2.setStatistics(s2);


        User u3 = new User("Super", "Sam", "123", "super@sam", new double []{-27.4785, 153.0284});
        UserStats s3 = new UserStats(504);
        s3.setJoinDate(LocalDate.of(2022, 4, 10));
        u3.setStatistics(s3);


        User u4 = new User("Crazy", "Chris", "123", "crazy@chris", new double []{-27.4785, 153.0284});
        UserStats s4 = new UserStats(24);
        s4.setJoinDate(LocalDate.of(2023, 5, 2));
        u4.setStatistics(s4);


        User u5 = new User("Mega", "Megan", "123", "mega@megan", new double []{-27.4785, 153.0284});
        UserStats s5 = new UserStats(267);
        s5.setJoinDate(LocalDate.of(2023, 5, 1));
        u5.setStatistics(s5);


        User u6 = new User("Radical", "Rachael", "123", "radical@rachael", new double []{-27.4785, 153.0284});
        UserStats s6 = new UserStats(35);
        s6.setJoinDate(LocalDate.of(2022, 10, 24));
        u6.setStatistics(s6);

        User u7 = new User("Lovable", "Loryn", "coffee", "coffee@coffee.com", new double []{-27.4785, 153.0284});
        UserStats s7 = new UserStats(158000);
        s7.setJoinDate(LocalDate.of(1901, 11, 8));
        u7.setStatistics(s7);

//        s2.addReview(new Review(5, "bestuser", "this guy is pretty good"));
//        s2.addReview(new Review(1, "baduser", "this guy is pretty bad"));


        userDAO.addUser(u1);
        userDAO.addUser(u2);
        userDAO.addUser(u3);
        userDAO.addUser(u4);
        userDAO.addUser(u5);
        userDAO.addUser(u6);
        userDAO.addUser(u7);

        System.out.println("Dummy users loaded");
        used = true;
    }


    public List<UserEntity> sortPoints(List<UserEntity> allUsers, String sort){
        List<UserEntity> userlist = new ArrayList<UserEntity>(allUsers);

        if(sort.equals("SaverPoints")){
            Collections.sort(userlist, new SaverPointsComparator());

        } else if(sort.equals("Reviews")){
//            Collections.sort(userlist, new ReviewComparator());
        }

        return userlist;
    }
}

class SaverPointsComparator implements java.util.Comparator<UserEntity>{
    @Override
    public int compare(UserEntity a, UserEntity b){
        return b.getSaverPoints() - a.getSaverPoints();
    }
}

//class ReviewComparator implements java.util.Comparator<UserEntity>{
//    @Override
//    public int compare(User a, User b){
//        return b.getStatistics().averageReviewsInt() - a.getStatistics().averageReviewsInt();
//    }
//}