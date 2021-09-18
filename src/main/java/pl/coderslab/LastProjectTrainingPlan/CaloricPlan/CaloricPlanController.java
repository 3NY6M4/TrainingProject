package pl.coderslab.LastProjectTrainingPlan.CaloricPlan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.LastProjectTrainingPlan.CaloricCalculator.CaloricCalculator;
import pl.coderslab.LastProjectTrainingPlan.CaloricCalculator.CaloricCalculatorService;
import pl.coderslab.LastProjectTrainingPlan.User.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/caloricPlans")
public class CaloricPlanController implements UserContextChecker {

    private final CaloricPlanService caloricPlanService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CaloricCalculatorService caloricCalculatorService;

    public CaloricPlanController(CaloricPlanService caloricPlanService, UserService userService, UserRepository userRepository, CaloricCalculatorService caloricCalculatorService) {
        this.caloricPlanService = caloricPlanService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.caloricCalculatorService = caloricCalculatorService;
    }
    @GetMapping("/allCaloricPlan")
    public String showPosts(Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password, @CookieValue(value = "UserId", defaultValue = "0")Long userId, @CookieValue("login") String name) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        User user = userRepository.findByLogin(name);
        List<CaloricPlan> caloricPlans = caloricPlanService.getCaloricPlanByUserId(user.getId());
        model.addAttribute("caloricPlans", caloricPlans);
        return "/allCaloricPlan";
    }
    @GetMapping("/editCaloricPlan/{id}")
    public String showEditForm(@PathVariable long id, Model model, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password, @CookieValue(value = "UserId", defaultValue = "0")Long userId, @CookieValue("login") String name) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        CaloricCalculator caloricCalculator = caloricPlanService.createCalculatorFromCaloricPlan(id);
        model.addAttribute("caloricCalculator", caloricCalculator);
        return "/editCaloricPlan";
    }
    @RequestMapping(value = "/editCaloricPlan", method = RequestMethod.POST)
    public String editCaloricPlan(@Valid CaloricCalculator caloricCalculator, BindingResult result) {
        if (result.hasErrors()) {
            return "/editCaloricPlan";
        }
        caloricCalculatorService.add(caloricCalculator);
        return "redirect:/caloricPlans/allCaloricPlan";
    }
    @GetMapping("/delete/{id}")
    public String deleteCaloricPlan(@PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        caloricPlanService.delete(id);
        return "redirect:/caloricPlans/allCaloricPlan";
    }
    @GetMapping("/showCaloricPlan/{id}")
    public String showCaloricPlan(Model model, @PathVariable long id, @CookieValue(value = "login", defaultValue = "") String login, @CookieValue(value = "password", defaultValue = "")String password) {
        if (!userHasBeenLogged()) return "redirect:/login";
        checkLogin(login, password);
        model.addAttribute("caloricPlan", caloricPlanService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/showCaloricPlan";
    }
    public void checkLogin(String login, String password) {
        List<User> users = userService.userGetByEmail(login, password);
        List<User> users1 = userService.userGetByLogin(login, password);
        if (users.size() == 0 && users1.size() == 0) {
            throw new ForbiddenException();
        }

    }
}