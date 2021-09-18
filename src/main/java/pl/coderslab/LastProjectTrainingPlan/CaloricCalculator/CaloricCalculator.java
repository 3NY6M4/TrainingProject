package pl.coderslab.LastProjectTrainingPlan.CaloricCalculator;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.LastProjectTrainingPlan.User.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CaloricCalculator {
    private long id;
    @Size(min = 1, max = 30)
    private String namePlan;

    private String goal;

    private int gender;

    private int type;
    @DecimalMin("0.1")
    private double weight;
    @DecimalMin("0.1")
    private double height;
    @DecimalMin("0.1")
    private int age;

    private double activity;

    @ManyToOne
    private User user;


}

