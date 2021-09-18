package pl.coderslab.LastProjectTrainingPlan.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.List;

@Controller
public class  UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public String register (Model model){
        model.addAttribute("user", new User ());
        return "/register";
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register (@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/register";
        } else {
            userService.add(user);
            return "redirect:/login";
        }
    }
    @GetMapping("/login")
    public String login (Model model){
        model.addAttribute("user", new User ());
        return "/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            model.addAttribute("error", "Niepoprawne dane logowania");
            return "/login";
        }
    List<User> users = userService.userGetByEmail(user.getLogin(), user.getPassword());
    List<User> users1 = userService.userGetByLogin(user.getLogin(), user.getPassword());
        if (users.size() == 0 && users1.size() == 0) {
        model.addAttribute("user", user);
        return "/login";
    }
        userService.saveUserContext(users,users1);
        Cookie cookieId = new Cookie("userId", String.valueOf(user.getId()));
        Cookie cookieLogin = new Cookie("login", user.getLogin());
        Cookie cookieEmail = new Cookie("email", user.getEmail());
        Cookie cookiePassword = new Cookie("password", user.getPassword());
        Cookie cookieName = new Cookie("name", user.getName());
        cookieLogin.setPath("/");
        response.addCookie(cookieId);
        response.addCookie(cookieLogin);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        response.addCookie(cookieName);
        return "redirect:/allCalculators";
    }

    @GetMapping(value = "/allCalculators")
    public String home(){
        return "allCalculators";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletResponse response){
        Cookie cookieId = new Cookie("id", "");
        Cookie cookieLogin = new Cookie("login", "");
        Cookie cookieEmail = new Cookie("email", "");
        Cookie cookiePassword = new Cookie("password", "");
        Cookie cookieName = new Cookie("name", "");
        response.addCookie(cookieId);
        response.addCookie(cookieLogin);
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        response.addCookie(cookieName);
        UserContextHolder.getContext().setUserId(null);
        return "redirect:/login";
    }
}