package pl.coderslab.LastProjectTrainingPlan.CaloricCalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.LastProjectTrainingPlan.CaloricPlan.CaloricPlanService;
import pl.coderslab.LastProjectTrainingPlan.User.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/caloricCalculators")
public class CaloricCalculatorController implements UserContextChecker {

    private final CaloricCalculatorService caloricCalculatorService;
    private final UserService userService;
    private final UserRepository userRepository;

    public CaloricCalculatorController(CaloricCalculatorService caloricCalculatorService, CaloricPlanService caloricPlanService, UserService userService, UserRepository userRepository) {
        this.caloricCalculatorService = caloricCalculatorService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/addCaloricCalculator")
    public String showAddForm(Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "") String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        model.addAttribute("caloricCalculator", new CaloricCalculator());
        return "/addCaloricCalculator";
    }

    @RequestMapping(value = "/addCaloricCalculator", method = RequestMethod.POST)
    public String saveCaloricCalculator(Model model, @Valid CaloricCalculator caloricCalculator, BindingResult result, @CookieValue("login")String login) {

        if (result.hasErrors()) {
            return "/addCaloricCalculator";
        }
        User user = userRepository.findByLogin(login);
        caloricCalculator.setUser(user);
        caloricCalculatorService.add(caloricCalculator);
        return "redirect:/caloricPlans/allCaloricPlan";
    }

    public void checkLogin(String login, String password) {
        List<User> users = userService.userGetByEmail(login, password);
        List<User> users1 = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }

    }
}