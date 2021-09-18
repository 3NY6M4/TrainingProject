package pl.coderslab.LastProjectTrainingPlan.User;

public interface UserContextChecker {

    default boolean userHasBeenLogged(){
        UserContextHolder context = UserContextHolder.getContext();
        return context.getUserId()!=null;
    }
}
