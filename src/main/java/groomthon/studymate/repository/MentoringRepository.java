package groomthon.studymate.repository;

import groomthon.studymate.entity.Mentoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoringRepository extends JpaRepository<Mentoring,Long> {
}
