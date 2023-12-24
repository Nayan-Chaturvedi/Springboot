package questionService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntityClass, Long> 
{
	List<QuestionEntityClass> findByQuizId(Long quizId);
}
