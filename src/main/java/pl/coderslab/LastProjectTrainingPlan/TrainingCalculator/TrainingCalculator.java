package pl.coderslab.LastProjectTrainingPlan.TrainingCalculator;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.LastProjectTrainingPlan.User.User;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TrainingCalculator {

    private long id;

    @Size(min = 1, max = 30)
    private String namePlan;

    private double progresion;

    @DecimalMin("0.1")
    private double weightBp;

    private double  repsBp;
    @DecimalMin("0.1")
    private double  weightSq;

    private double  repsSq;
    @DecimalMin("0.1")
    private double  weightDl;

    private double  repsDl;

    private Boolean benchPress;
    private Boolean deadlift;
    private Boolean squat;

    private String weeks;

    @ManyToOne
    private User user;

}

