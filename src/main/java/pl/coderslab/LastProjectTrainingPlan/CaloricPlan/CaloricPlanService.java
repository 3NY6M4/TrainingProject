package pl.coderslab.LastProjectTrainingPlan.CaloricPlan;

import pl.coderslab.LastProjectTrainingPlan.CaloricCalculator.CaloricCalculator;

import java.util.List;
import java.util.Optional;

public interface CaloricPlanService {

    Optional<CaloricPlan> get(Long id);

    void add(CaloricPlan caloricPlan);


    void delete(Long id);

    CaloricCalculator createCalculatorFromCaloricPlan(long id);

    List<CaloricPlan> getCaloricPlanByUserId(Long userId);
}


