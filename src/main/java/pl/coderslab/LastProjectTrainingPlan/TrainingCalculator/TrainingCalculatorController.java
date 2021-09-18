package pl.coderslab.LastProjectTrainingPlan.TrainingCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.LastProjectTrainingPlan.TrainingPlan.TrainingPlanService;
import pl.coderslab.LastProjectTrainingPlan.User.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/trainingCalculators")
public class TrainingCalculatorController implements UserContextChecker {

    private final TrainingCalculatorService trainingCalculatorService;
    private final UserService userService;
    private final UserRepository userRepository;

    public TrainingCalculatorController(TrainingCalculatorService trainingCalculatorService, TrainingPlanService trainingPlanService, UserService userService, UserRepository userRepository) {
        this.trainingCalculatorService = trainingCalculatorService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/addTrainingCalculator")
    public String showAddForm(Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "") String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        model.addAttribute("trainingCalculator", new TrainingCalculator());
        return "/addTrainingCalculator";
    }

    @RequestMapping(value = "/addTrainingCalculator", method = RequestMethod.POST)
    public String saveTrainingCalculator(Model model, @Valid TrainingCalculator trainingCalculator, BindingResult result, @CookieValue("login")String login) {

        if (!trainingCalculator.getDeadlift()&&!trainingCalculator.getSquat()&&!trainingCalculator.getBenchPress()){
            model.addAttribute("checkoboxError", "Żaden bój treningowy nie został zaznaczony");
            return "/addTrainingCalculator";
        }
        if (trainingCalculator.getProgresion()==0.0){
            model.addAttribute("errorRadioButton", "RadioButton cannot be empty");
            return "/addTrainingCalculator";

        }
        User user = userRepository.findByLogin(login);
        trainingCalculator.setUser(user);

        String addingMessage = trainingCalculatorService.add(trainingCalculator);
        if (!addingMessage.isEmpty()){
            model.addAttribute("databaseValidationError", addingMessage);
            return "/addTrainingCalculator";
        }
        else {

        }
        return "redirect:/trainingPlans/allTrainingPlan";
        }

    public void checkLogin(String login, String password) {
        List<User> users = userService.userGetByEmail(login, password);
        List<User> users1 = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }

    }
}