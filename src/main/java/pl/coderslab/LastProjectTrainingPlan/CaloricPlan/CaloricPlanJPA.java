package pl.coderslab.LastProjectTrainingPlan.CaloricPlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.LastProjectTrainingPlan.CaloricCalculator.CaloricCalculator;

import java.util.List;
import java.util.Optional;

@Service
public class CaloricPlanJPA implements CaloricPlanService {

    private final CaloricPlanRepository caloricPlanRepository;
    @Autowired
    public CaloricPlanJPA(CaloricPlanRepository caloricPlanRepository) { this.caloricPlanRepository = caloricPlanRepository; }

    @Override
    public Optional<CaloricPlan> get(Long id) { return caloricPlanRepository.findById(id); }

    @Override
    public void add(CaloricPlan caloricPlan) {
        caloricPlanRepository.save(caloricPlan);
    }

    @Override
    public void delete(Long id) {
        caloricPlanRepository.deleteById(id);
    }

    @Override
    public CaloricCalculator createCalculatorFromCaloricPlan(long id) {

        Optional<CaloricPlan> caloricPlan = caloricPlanRepository.findById(id);

        CaloricCalculator caloricCalculator = new CaloricCalculator();
        caloricCalculator.setId(caloricPlan.get().getId());
        caloricCalculator.setNamePlan(caloricPlan.get().getNamePlan());
        caloricCalculator.setGoal(caloricPlan.get().getGoal());
        caloricCalculator.setGender(caloricPlan.get().getGender());
        caloricCalculator.setType(caloricPlan.get().getType());
        caloricCalculator.setWeight(caloricPlan.get().getWeight());
        caloricCalculator.setHeight(caloricPlan.get().getHeight());
        caloricCalculator.setWeight(caloricPlan.get().getWeight());
        caloricCalculator.setAge(caloricPlan.get().getAge());
        caloricCalculator.setActivity(caloricPlan.get().getActivity());

        return caloricCalculator;
    }
    @Override
    public List<CaloricPlan> getCaloricPlanByUserId(Long userId) {
        return caloricPlanRepository.findAllByUserId(userId);
    }
}