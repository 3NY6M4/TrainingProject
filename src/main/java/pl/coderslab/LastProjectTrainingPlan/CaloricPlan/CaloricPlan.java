package pl.coderslab.LastProjectTrainingPlan.CaloricPlan;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "CaloricPlans")

public class CaloricPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String namePlan;

    private String goal;

    private double weight;

    private double height;

    private int age;

    private int type;

    private int gender;

    private double activity;

    private double caloriesTarget;
    private String protein;
    private String carbohydrates;
    private String fats;

    private Timestamp createDate;
    private Timestamp finishDate;

    private long userId;

}