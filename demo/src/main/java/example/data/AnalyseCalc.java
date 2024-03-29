package example.data;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class AnalyseCalc {

    private final StaticUserDAO userDAO = new StaticUserDAO();

    public void saveUserPoints(User user, String firstName, String lastName, int userPoints) {
        if (firstName != null && !firstName.isEmpty()){
            user.setFirstName(firstName);
        }

        if (lastName != null && !lastName.isEmpty()){
            user.setLastName(lastName);
        }

        userDAO.updateUser(user);

    }
    public long days(String currentDate, String expiredDate) {
        var first_date = new Date(currentDate);
        var second_date = new Date(expiredDate);

        var sub = second_date.getTime() - first_date.getTime(); // If output, measured in milliseconds
        //long totalDays = Math.divideExact(sub, 86400000);
        long totalDays = sub / 86400000; // Convert from milliseconds to days

        if (totalDays <= 0) {
            totalDays = 0;
        }
        return totalDays;
    }


    public double calculateFoodConsumption(int currentMass, int initialMass) {
        double foodConsumption = Math.floor((currentMass / (double) initialMass) * 100);
        return foodConsumption;
    }

    public String pointsArray(double foodConsumption) {
        double pointConverter = foodConsumption;
        ArrayList<String> itemPoints = new ArrayList<String>();
        itemPoints.add("5");
        itemPoints.add("10");
        itemPoints.add("15");
        itemPoints.add("20");
        itemPoints.add("25");
        itemPoints.add("30");
        itemPoints.add("50");

        if (pointConverter > 0) {
            if (pointConverter < 5) {
                return itemPoints.get(0);
            } else if (pointConverter <= 15) {
                return itemPoints.get(1);
            } else if (pointConverter <= 25) {
                return itemPoints.get(2);
            } else if (pointConverter <= 40) {
                return itemPoints.get(3);
            } else if (pointConverter <= 50) {
                return itemPoints.get(4);
            } else {
                if (pointConverter <= 90) {
                    return itemPoints.get(5);
                }
                else {
                    return itemPoints.get(6);
                }
            }
        }
        return null;
    }

    public int ConvertInt(double totalStrPoints) {
        return parseInt(pointsArray(totalStrPoints));
    }
}
