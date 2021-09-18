package pl.coderslab.LastProjectTrainingPlan.TrainingPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.LastProjectTrainingPlan.TrainingCalculator.TrainingCalculator;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingPlanJPA implements TrainingPlanService {

    private final TrainingPlanRepository trainingPlanRepository;
    @Autowired
    public TrainingPlanJPA(TrainingPlanRepository trainingPlanRepository) { this.trainingPlanRepository = trainingPlanRepository; }

    @Override
    public Optional<TrainingPlan> get(Long id) {
        return trainingPlanRepository.findById(id);
    }

    @Override
    public void add(TrainingPlan trainingPlan) { trainingPlanRepository.save(trainingPlan); }

    @Override
    public void delete(Long id) {
        trainingPlanRepository.deleteById(id);
    }

    @Override
    public TrainingCalculator createCalculatorFromTrainingPlan(long id) {
        Optional<TrainingPlan> trainingPlanOptional = trainingPlanRepository.findById(id);
        TrainingPlan trainingPlan = trainingPlanOptional.orElse(null);

        TrainingCalculator trainingCalculator = new TrainingCalculator();
        trainingCalculator.setId(trainingPlan.getId());
        trainingCalculator.setNamePlan(trainingPlan.getNamePlan());
        trainingCalculator.setWeightSq(trainingPlan.getWeightSq());
        trainingCalculator.setRepsSq(trainingPlan.getRepsSq());
        trainingCalculator.setWeightDl(trainingPlan.getWeightDl());
        trainingCalculator.setRepsDl(trainingPlan.getRepsDl());
        trainingCalculator.setWeightBp(trainingPlan.getWeightBp());
        trainingCalculator.setRepsBp(trainingPlan.getRepsBp());
        trainingCalculator.setWeeks(trainingPlan.getWeeks());
        trainingCalculator.setProgresion(trainingPlan.getProgresion());

        return trainingCalculator;
    }
    @Override
    public List<TrainingPlan> getTrainingPlanByUserId(Long userId) {
        return trainingPlanRepository.findAllByUserId(userId);
    }

}