package pl.coderslab.LastProjectTrainingPlan.TrainingPlan;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.LastProjectTrainingPlan.TrainingCalculator.TrainingCalculator;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "TrainingPlans")

public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 1, max = 30)
    private String namePlan;

    private Timestamp createDate;
    private Timestamp finishDate;

    private double progresion;

    private boolean benchPress;
    private boolean deadlift;
    private boolean squat;

    @DecimalMin("0.1")
    private double weightBp;

    private double repsBp;
    @DecimalMin("0.1")
    private double weightSq;

    private double repsSq;
    @DecimalMin("0.1")
    private double weightDl;

    private double repsDl;

    private String weeks;

    private long userId;

}
