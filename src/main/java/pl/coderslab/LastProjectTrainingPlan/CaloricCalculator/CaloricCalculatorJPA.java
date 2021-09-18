package pl.coderslab.LastProjectTrainingPlan.CaloricCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.LastProjectTrainingPlan.CaloricPlan.CaloricPlan;
import pl.coderslab.LastProjectTrainingPlan.CaloricPlan.CaloricPlanRepository;
import pl.coderslab.LastProjectTrainingPlan.User.User;
import pl.coderslab.LastProjectTrainingPlan.User.UserRepository;
import pl.coderslab.LastProjectTrainingPlan.User.UserContextHolder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CaloricCalculatorJPA implements CaloricCalculatorService {

    private final CaloricPlanRepository caloricPlanRepository;
    private final UserRepository userRepository;

    @Autowired
    public CaloricCalculatorJPA(CaloricPlanRepository caloricPlanRepository, UserRepository userRepository) {

        this.caloricPlanRepository = caloricPlanRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(CaloricCalculator caloricCalculator) {
        User loggedUser = findLoggedUser();
        caloricCalculator.setUser(loggedUser);

        CaloricPlan caloricPlan = null;
        Optional<CaloricPlan> optionalCaloricPlan = caloricPlanRepository.findById(caloricCalculator.getId());
        if (optionalCaloricPlan.isPresent()){
            caloricPlan = optionalCaloricPlan.get();
        }
        else {
            caloricPlan = new CaloricPlan();
        }
        caloricPlan.setUserId(caloricCalculator.getUser().getId());
        caloricPlan.setNamePlan(caloricCalculator.getNamePlan());
        caloricPlan.setGoal(caloricCalculator.getGoal());
        caloricPlan.setGender(caloricCalculator.getGender());
        caloricPlan.setType(caloricCalculator.getType());
        caloricPlan.setActivity(caloricCalculator.getActivity());
        caloricPlan.setWeight(caloricCalculator.getWeight());
        caloricPlan.setHeight(caloricCalculator.getHeight());
        caloricPlan.setAge(caloricCalculator.getAge());
        caloricPlan.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        caloricPlan.setCaloriesTarget(caloricCalculator.getActivity() * caloricCalculator.getWeight());

        caloricPlanRepository.save(caloricPlan);

    }
    private User findLoggedUser() {
        UserContextHolder userContextHolder = UserContextHolder.getContext();
        Optional<User> optionalUser = userRepository.findById(userContextHolder.getUserId());
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("Uzytkownik nie jest zalogowany");
        }
        return optionalUser.get();
    }

}