package pl.coderslab.LastProjectTrainingPlan.TrainingPlan;

import pl.coderslab.LastProjectTrainingPlan.TrainingCalculator.TrainingCalculator;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanService {

    Optional<TrainingPlan> get(Long id);

    void add(TrainingPlan trainingPlan);

    void delete(Long id);

    TrainingCalculator createCalculatorFromTrainingPlan(long id);

    List<TrainingPlan> getTrainingPlanByUserId(Long userId);
}


