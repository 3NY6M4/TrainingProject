package pl.coderslab.LastProjectTrainingPlan.CaloricPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaloricPlanRepository extends JpaRepository<CaloricPlan, Long> {

    List<CaloricPlan> findAllByUserId(Long userId);
}