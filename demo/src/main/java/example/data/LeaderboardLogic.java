package example.data;

import java.time.LocalDate;
import java.util.*;

public class LeaderboardLogic {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

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
        UserStats s2 = new UserStats(1001);
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
        UserStats s5 = new UserStats(857);
        s5.setJoinDate(LocalDate.of(2023, 5, 1));
        u5.setStatistics(s5);


        User u6 = new User("Radical", "Rachael", "123", "radical@rachael", new double []{-27.4785, 153.0284});
        UserStats s6 = new UserStats(611);
        s6.setJoinDate(LocalDate.of(2022, 10, 24));
        u6.setStatistics(s6);


        s2.addReview(new Review(5, "bestuser", "this guy is pretty good"));
        s2.addReview(new Review(1, "baduser", "this guy is pretty bad"));


        userDAO.addUser(u1);
        userDAO.addUser(u2);
        userDAO.addUser(u3);
        userDAO.addUser(u4);
        userDAO.addUser(u5);
        userDAO.addUser(u6);

        System.out.println("Dummy users loaded");
        used = true;
    }


    public List<User> sortPoints(String sort){
        List<User> userlist = new ArrayList<User>(userDAO.listUsers());

        if(sort.equals("SaverPoints")){
            Collections.sort(userlist, new SaverPointsComparator());

        } else if(sort.equals("Reviews")){
            Collections.sort(userlist, new ReviewComparator());
        }

        return userlist;
    }
}

class SaverPointsComparator implements java.util.Comparator<User>{
    @Override
    public int compare(User a, User b){
        return b.getStatistics().getPoints() - a.getStatistics().getPoints();
    }
}

class ReviewComparator implements java.util.Comparator<User>{
    @Override
    public int compare(User a, User b){
        return b.getStatistics().averageReviewsInt() - a.getStatistics().averageReviewsInt();
    }
}