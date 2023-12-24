package questionService;

import java.util.List;


public interface QuestionService 
{
	QuestionEntityClass add(QuestionEntityClass ec);
	
	List<QuestionEntityClass> get();
    
    QuestionEntityClass get(Long id);
    
    List<QuestionEntityClass> getQuestionsOfQuiz(Long quizId);
}
