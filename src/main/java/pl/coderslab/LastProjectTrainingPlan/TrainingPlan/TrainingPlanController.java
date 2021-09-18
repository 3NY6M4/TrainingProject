package pl.coderslab.LastProjectTrainingPlan.TrainingPlan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.LastProjectTrainingPlan.TrainingCalculator.TrainingCalculator;
import pl.coderslab.LastProjectTrainingPlan.TrainingCalculator.TrainingCalculatorService;
import pl.coderslab.LastProjectTrainingPlan.User.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/trainingPlans")
public class TrainingPlanController implements UserContextChecker {

    private final TrainingPlanService trainingPlanService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final TrainingCalculatorService trainingCalculatorService;
    private final UserContextHolder userContextHolder = UserContextHolder.getContext();

    public TrainingPlanController(TrainingPlanService trainingPlanService, UserService userService, UserRepository userRepository, TrainingCalculatorService trainingCalculatorService) {
        this.trainingPlanService = trainingPlanService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.trainingCalculatorService = trainingCalculatorService;
    }
    @GetMapping("/allTrainingPlan")
    public String showPosts(Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password, @CookieValue(value = "UserId", defaultValue = "0")Long userId, @CookieValue("login") String name) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);

        User user = userRepository.findByLogin(name);
        List<TrainingPlan> trainingPlans = trainingPlanService.getTrainingPlanByUserId(user.getId());
        model.addAttribute("trainingPlans", trainingPlans);
        return "/allTrainingPlan";
    }
    @GetMapping("/editTrainingPlan/{id}")
    public String showEditForm(@PathVariable long id, Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password, @CookieValue(value = "UserId", defaultValue = "0")Long userId, @CookieValue("login") String name) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        TrainingCalculator trainingCalculator = trainingPlanService.createCalculatorFromTrainingPlan(id);
        model.addAttribute("trainingCalculator", trainingCalculator);
        return "/editTrainingPlan";
    }
    @RequestMapping(value = "/editTrainingPlan", method = RequestMethod.POST)
    public String editTrainingPlan(@Valid TrainingCalculator trainingCalculator, BindingResult result) {
        if (result.hasErrors()) {
            return "/editTrainingPlan";
        }
        if (userContextHolder.getUserId()==null){
            return "redirect:/login";
        }
        trainingCalculatorService.add(trainingCalculator);
        return "redirect:/trainingPlans/allTrainingPlan";
    }
    @GetMapping("/delete/{id}")
    public String deleteTrainingPlan(@PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        trainingPlanService.delete(id);
        return "redirect:/trainingPlans/allTrainingPlan";
    }
    @GetMapping("/showTrainingPlan/{id}")
    public String showTrainingPlan(Model model, @PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        model.addAttribute("trainingPlan", trainingPlanService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/showTrainingPlan";
    }
    public void checkLogin(String login, String password) {
        List<User> users = userService.userGetByEmail(login, password);
        List<User> users1 = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }

    }
}