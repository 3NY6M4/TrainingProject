package pl.coderslab.LastProjectTrainingPlan.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> get(Long id);

    void add(User user);

    List<User> userGetByEmail(String email, String password);

    List<User> userGetByLogin(String login, String password);

    void saveUserContext(List<User> users, List<User> users1);
}


