package pl.coderslab.LastProjectTrainingPlan.TrainingCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.LastProjectTrainingPlan.TrainingPlan.TrainingPlan;
import pl.coderslab.LastProjectTrainingPlan.TrainingPlan.TrainingPlanRepository;
import pl.coderslab.LastProjectTrainingPlan.User.User;
import pl.coderslab.LastProjectTrainingPlan.User.UserRepository;
import pl.coderslab.LastProjectTrainingPlan.User.UserContextHolder;

import javax.validation.ConstraintViolationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingCalculatorJPA implements TrainingCalculatorService {

    private final TrainingPlanRepository trainingPlanRepository;
    private final UserRepository userRepository;

    @Autowired
    public TrainingCalculatorJPA(TrainingPlanRepository trainingPlanRepository, UserRepository userRepository) {

        this.trainingPlanRepository = trainingPlanRepository;
        this.userRepository = userRepository;
    }

    @Override
    public String add(TrainingCalculator trainingCalculator) {
        User loggedUser = findLoggedUser();
        trainingCalculator.setUser(loggedUser);

        TrainingPlan trainingPlan = null;
        Optional<TrainingPlan> optionalTrainingPlan = trainingPlanRepository.findById(trainingCalculator.getId());
        if (optionalTrainingPlan.isPresent()){
            trainingPlan = optionalTrainingPlan.get();
        }
        else {
            trainingPlan = new TrainingPlan();
        }
        trainingPlan.setUserId(trainingCalculator.getUser().getId());
        trainingPlan.setNamePlan(trainingCalculator.getNamePlan());
        trainingPlan.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        trainingPlan.setFinishDate(Timestamp.valueOf(LocalDateTime.now().plusWeeks(Long.parseLong(trainingCalculator.getWeeks()))));
        trainingPlan.setBenchPress(trainingCalculator.getBenchPress());
        trainingPlan.setWeightBp(trainingCalculator.getWeightBp());
        trainingPlan.setRepsBp(trainingCalculator.getRepsBp());
        trainingPlan.setDeadlift(trainingCalculator.getDeadlift());
        trainingPlan.setRepsDl(trainingCalculator.getRepsDl());
        trainingPlan.setWeightDl(trainingCalculator.getWeightDl());
        trainingPlan.setSquat(trainingCalculator.getSquat());
        trainingPlan.setRepsSq(trainingCalculator.getRepsSq());
        trainingPlan.setWeeks(trainingCalculator.getWeeks());
        trainingPlan.setProgresion(trainingCalculator.getProgresion());
        trainingPlan.setWeightSq(trainingCalculator.getWeightSq());

        try {
            trainingPlanRepository.save(trainingPlan);
        } catch (ConstraintViolationException cve){
        return cve.getConstraintViolations().stream().map(constraintViolation -> constraintViolation.getMessage()).limit(1).collect(Collectors.toList()).get(0);
        }
        return "";
    }
    private User findLoggedUser() {
        UserContextHolder userContextHolder = UserContextHolder.getContext();
        Optional<User> optionalUser = userRepository.findById(userContextHolder.getUserId());
        if (!optionalUser.isPresent()){
            throw new RuntimeException("Uzytkownik nie jest zalogowany");
        }
        return optionalUser.get();
    }


}