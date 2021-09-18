package pl.coderslab.LastProjectTrainingPlan.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class UserJPA implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserJPA(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> userGetByEmail(String email, String password) {
        return userRepository.findAllByEmailAndPassword(email, password);
    }
    @Override
    public List<User> userGetByLogin(String login, String password) {
        return userRepository.findAllByLoginAndPassword(login, password);
    }

    @Override
    public void saveUserContext(List<User> users, List<User> users1) {
      User loggedUser;
      if (!users.isEmpty()){
          loggedUser=users.get(0);
      }
      else {
          loggedUser = users1.get(0);
      }
        UserContextHolder.getContext().setUserId(loggedUser.getId());
    }



}