package example.application.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="FOOD")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "FOOD_TYPE")
    private String foodType;

    @Column(name = "EXP")
    private Date expiry;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "STATE")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FoodEntity [id=" + id + ", foodName=" + foodName +
                ", foodType=" + foodType + ", expiry=" + expiry +
                ", weight=" + weight + ", state=" + state + "]";
    }
}
