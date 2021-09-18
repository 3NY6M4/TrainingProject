package pl.coderslab.LastProjectTrainingPlan.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByLoginAndPassword(String login, String password);

    List<User> findAllByEmailAndPassword(String email, String password);

    User findByLogin(String login);

}