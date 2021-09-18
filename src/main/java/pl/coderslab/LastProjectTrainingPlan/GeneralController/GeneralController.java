package pl.coderslab.LastProjectTrainingPlan.GeneralController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class GeneralController {
    @GetMapping("")
    public String homePage (){
        return "/general";
    }

}